package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.*;
import com.abc.performancemanagement.service.AchievementsService;
import com.abc.performancemanagement.service.CreditService;
import com.abc.performancemanagement.service.PerformanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<PerformanceResult> perByUser = performanceService.getPerByUser(personnelManagement.getpId()); //获取某人每个月的绩点总和

        //这地方容易出错
        List<Credit> price = creditService.getPrice(personnelManagement.getpDepartment());//获取这个部门每个绩点多少钱
        Integer cPrice = price.get(1).getCPrice();


        for (int i = 0 ; i < perByUser.size() ; i++){
            Achievements result = new Achievements();
            Double value = perByUser.get(i).getValue(); //某个月绩点总和
            result.setAcId(personnelManagement.getpId());
            result.setAcDepart(personnelManagement.getpDepartment());
            result.setAcTeam(personnelManagement.getpTeam());
            result.setAcPost(personnelManagement.getpPost());
            result.setAcDate(perByUser.get(i).getDate());
            result.setAcValue(value);
            result.setAcSalary(value * cPrice);
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



    //获取某人每个月绩效综合 包括奖金
    @PostMapping("/getByUserMonth")
    public Object getByUserMonth(@RequestBody Achievements achievements){
        List<Achievements> byUserMonth = achievementsService.getByUserMonth(achievements.getAcId());
        if(byUserMonth != null){
            return new ResultMsg<List<Achievements>>(200,"获取数据成功！",byUserMonth);
        }
        return new ResultMsg<List<Achievements>>(400,"无数据！",null);
    }



    //医院绩效总和
    @GetMapping("/getCombined")
    public Object getCombined(){
        List<PerformanceOfTheCombinedDepart> combined = achievementsService.getCombined();
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepart>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombined>>(400,"无数据！",null);
    }


    @PostMapping("/getCombinedByDepart")
    public Object getCombinedByDepart(@RequestBody PerformanceOfTheCombinedDepart performanceOfTheCombined){
        List<PerformanceOfTheCombinedDepart> combined = achievementsService.getCombinedByDepart(performanceOfTheCombined.getDepart());
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepart>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombinedDepart>>(400,"无数据！",null);
    }


    @GetMapping("/getCombinedAllDepart")
    public Object getCombinedByDepart(){
        List<PerformanceOfTheCombinedDepart> combined = achievementsService.getCombinedAllDepart();
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepart>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombinedDepart>>(400,"无数据！",null);
    }

    @PostMapping("/getCombinedByDepartAndTeam")
    public Object getCombinedByDepartAndTeam(@RequestBody PerformanceOfTheCombinedDepartAndTeam performanceOfTheCombined){
        List<PerformanceOfTheCombinedDepartAndTeam> combined = achievementsService.getCombinedByDepartAndTeam(performanceOfTheCombined.getDepart(),performanceOfTheCombined.getTeam());
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeam>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeam>>(400,"无数据！",null);
    }



    @PostMapping("/getCombinedByDepartAndTeamAndPost")
    public Object getCombinedByDepartAndTeam(@RequestBody PerformanceOfTheCombinedDepartAndTeamAndPost performanceOfTheCombined){
        List<PerformanceOfTheCombinedDepartAndTeamAndPost> combined = achievementsService.getCombinedByDepartAndTeamAndPost(performanceOfTheCombined.getDepart(),performanceOfTheCombined.getTeam(),performanceOfTheCombined.getPost());
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeamAndPost>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeam>>(400,"无数据！",null);
    }


    @PostMapping("/getCombinedByDepartAndTeamAllPost")
    public Object getCombinedByDepartAllTeam(@RequestBody PerformanceOfTheCombinedDepartAndTeamAndPost performanceOfTheCombined){
        List<PerformanceOfTheCombinedDepartAndTeamAndPost> combined = achievementsService.getCombinedByDepartAndTeamAllPost(performanceOfTheCombined.getDepart(),performanceOfTheCombined.getTeam());
        if(combined != null){
            return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeamAndPost>>(200,"获取数据成功！",combined);
        }
        return new ResultMsg<List<PerformanceOfTheCombinedDepartAndTeam>>(400,"无数据！",null);
    }

}
