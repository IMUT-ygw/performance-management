package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.AchievementsMapper;
import com.abc.performancemanagement.pojo.Achievements;
import com.abc.performancemanagement.pojo.PersonnelManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementsService {

    @Autowired
    private AchievementsMapper achievementsMapper;


    //添加
    public Integer addAchievement(Achievements achievements){
        return achievementsMapper.addAchievements(achievements);
    }

    //判断用户是否存在
    public Boolean getAchByDate(String date,String user){
        Achievements achByDate = achievementsMapper.getAchByDate(date,user);
        return achByDate == null;
    }


    //更新
    public Integer updateAch(Achievements achievements){
        return achievementsMapper.updateAch(achievements);
    }



}
