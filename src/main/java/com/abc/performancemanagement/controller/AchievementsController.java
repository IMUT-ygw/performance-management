package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.*;
import com.abc.performancemanagement.service.AchievementsService;
import com.abc.performancemanagement.service.CreditService;
import com.abc.performancemanagement.service.PerformanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/achievement")
@Slf4j
public class AchievementsController {

    @Autowired
    private AchievementsService achievementsService;

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private CreditService creditService;

    //获取每个月员工的绩点总数及奖金
    @PostMapping("/addAchievement")
    public Object addAchievement(@RequestBody PersonnelManagement personnelManagement){
        log.info("参数： " + personnelManagement.toString());
        Integer resultInteger = 0;
        List<PerformanceResult> perByUser = performanceService.getPerByUser(personnelManagement.getPId()); //获取某人每个月的绩点总和
        Integer price = creditService.getPrice(personnelManagement.getPDepartment()); //获取这个部门每个绩点多少钱
        for (int i = 0 ; i < perByUser.size() ; i++){
            Achievements result = new Achievements();
            Double value = perByUser.get(i).getValue(); //某个月绩点总和
            result.setAcId(personnelManagement.getPId());
            result.setAcDepart(personnelManagement.getPDepartment());
            result.setAcTeam(personnelManagement.getPTeam());
            result.setAcPost(personnelManagement.getPPost());
            result.setAcDate(perByUser.get(i).getDate());
            result.setAcValue(value);
            result.setAcSalary(value * price);
            log.info("结果：" + result);
            if(achievementsService.getAchByDate(result.getAcDate(),perByUser.get(i).getUser())) {
                System.out.println("添加了");
                resultInteger = achievementsService.addAchievement(result);
            }else{
                System.out.println("更新了");
                resultInteger =achievementsService.updateAch(result);
            }
        }
        return new ResultMsg<Integer>(200,"插入数据成功:" + resultInteger,null);
    }

}
