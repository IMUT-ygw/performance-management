package com.abc.performancemanagement.controller;


import com.abc.performancemanagement.pojo.Performance;
import com.abc.performancemanagement.pojo.PerformanceResult;
import com.abc.performancemanagement.pojo.ResultMsg;
import com.abc.performancemanagement.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    //获取某人每个月绩效总和
    @PostMapping("/getPerByUser")
    public Object getPerByUser(@RequestBody Performance performance){
        List<PerformanceResult> perByUser = performanceService.getPerByUser(performance.getPerUser());
        return perByUser;
    }


    //获取绩效详细信息
    @PostMapping("/getAllPer")
    public Object getAllPer(@RequestBody Performance performance){
        List<Performance> perByUser = performanceService.getPre(performance.getPerUser());
        return perByUser;
    }


    //添加绩效
    @PostMapping("/addPerformance")
    public Object addPerformance(@RequestBody Performance performance ){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Timestamp ts = Timestamp.valueOf(time);
        performance.setPerDate(ts);
        System.out.println("参数"+performance);
        Integer integer = performanceService.addPer(performance);
        if (integer < 1) {
            return new ResultMsg<Object>(400, "添加失败", null);
        }
        return new ResultMsg<Object>(200, "添加成功，添加条数：" + integer, null);
    }




}
