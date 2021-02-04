package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.AchievementsMapper;
import com.abc.performancemanagement.pojo.*;
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


    public Integer deleteUser(String userId){
        return achievementsMapper.deleteUser(userId);
    }

    //获取某人月绩效及奖金
    public List<Achievements> getByUserMonth(String acId){
        return achievementsMapper.getByUserAddMonth(acId);
    }




    //获取医院总效绩
    public List<PerformanceOfTheCombinedDepart> getCombined(){
        return  achievementsMapper.getCombined();
    }

    //获取医院总效绩某部门
    public List<PerformanceOfTheCombinedDepart> getCombinedByDepart(String depart){
        return  achievementsMapper.getCombinedByDepart(depart);
    }


    //获取医院总效绩某部门某科室
    public List<PerformanceOfTheCombinedDepartAndTeam> getCombinedByDepartAndTeam(String depart,String team){
        return  achievementsMapper.getCombinedByDepartAndTeam(depart,team);
    }


    //获取医院总效绩某部门某科室某个岗位
    public List<PerformanceOfTheCombinedDepartAndTeamAndPost> getCombinedByDepartAndTeamAndPost(String depart,String team,String post){
        return  achievementsMapper.getCombinedByDepartAndTeamAndPost(depart,team,post);
    }


    //获取所有部门信息
    public List<PerformanceOfTheCombinedDepart> getCombinedAllDepart(){
        return  achievementsMapper.getCombinedAllDepart();
    }


    //获取所有部门信息
    public List<PerformanceOfTheCombinedDepartAndTeamAndPost> getCombinedByDepartAndTeamAllPost(String depart,String team){
        return  achievementsMapper.getCombinedByDepartAndTeamAllPost(depart,team);
    }
}
