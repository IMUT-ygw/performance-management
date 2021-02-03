package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.PerformanceMapper;
import com.abc.performancemanagement.pojo.Performance;
import com.abc.performancemanagement.pojo.PerformanceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceMapper performanceMapper;

    //获取员工月绩点总和
    public List<PerformanceResult> getPerByUser(String user){
        return performanceMapper.getPerByUser(user);
    }

    //添加员工绩效详情
    public Integer addPer(Performance performance){
        return performanceMapper.addPerformance(performance);
    }

    public Integer deleteUser(String userId){
        return performanceMapper.deleteUser(userId);
    }


    //获取员工具体工作信息
    public List<Performance> getPre(String userId){
        return performanceMapper.getPer(userId);
    }
}
