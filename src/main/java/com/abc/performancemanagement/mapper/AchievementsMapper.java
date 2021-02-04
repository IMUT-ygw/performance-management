package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AchievementsMapper {


    //插入记录（内部使用，不可管理手动添加）
    @Insert("insert into achievements values(#{acId},#{acTeam},#{acPost},#{acDate},#{acValue},#{acDepart},#{acSalary})")
    @Options(keyColumn = "ac_id",keyProperty = "acId",useGeneratedKeys = true)
    Integer addAchievements(Achievements achievements);

    //日期查重 如果存在 就更新数据
    @Select("select * from achievements where ac_date = #{acDate} and ac_id = #{acId}")
    Achievements getAchByDate(String acDate,String acId);


    //更新记录
    @Update({"<script>",
            "update achievements",
            "<set>",
            "<if test='acTeam != null'>",
            "ac_team = #{acTeam} ,",
            "</if>",
            "<if test='acPost != null'>",
            "ac_post = #{acPost} ,",
            "</if>",
            "<if test='acDate != null'>",
            "ac_date = #{acDate} ,",
            "</if>",
            "<if test='acValue != null'>",
            "ac_value = #{acValue} ,",
            "</if>",
            "<if test='acDepart != null'>",
            "ac_depart = #{acDepart} ,",
            "</if>" ,
            "<if test='acSalary != null'>",
            "ac_salary = #{acSalary} ,",
            "</if>" ,
            "</set>",
            "where ac_id = #{acId} and ac_date = #{acDate}",
            "</script>"})
    Integer updateAch(Achievements achievements);


    @Delete("delete from achievements where ac_id = #{acId}")
    Integer deleteUser(String acId);



    @Select("select * from achievements where ac_id = #{acId}")
    List<Achievements> getByUserAddMonth(String acId);


    //获取所有部门绩效奖金
    @Select("SELECT ac_depart as depart ,SUM(ac_value) as price ,ac_date as date ,SUM(ac_salary) as money FROM achievements GROUP BY ac_date;")
    List<PerformanceOfTheCombinedDepart> getCombinedAllDepart();

    //获取医院绩效奖金
    @Select("SELECT ac_depart as depart ,SUM(ac_value) AS price ,ac_date AS date ,SUM(ac_salary) AS money FROM achievements GROUP BY ac_date;")
    List<PerformanceOfTheCombinedDepart> getCombined();

    //获取某个部门的绩效奖金
    @Select("SELECT ac_depart as depart,SUM(ac_value) AS price ,ac_date AS date ,SUM(ac_salary) AS money FROM achievements WHERE ac_depart = #{depart} GROUP BY ac_date ;")
    List<PerformanceOfTheCombinedDepart> getCombinedByDepart(String depart);

    //获取某个部门某个科室的绩效奖金
    @Select("SELECT ac_team as team ,ac_depart as depart,SUM(ac_value) AS price ,ac_date AS date ,SUM(ac_salary) AS money FROM achievements WHERE ac_depart = #{depart} and ac_team = #{team} GROUP BY ac_date ;")
    List<PerformanceOfTheCombinedDepartAndTeam> getCombinedByDepartAndTeam(String depart,String team);


    //获取所有岗位信息
    @Select("SELECT ac_post as post, ac_team as team ,ac_depart as depart,SUM(ac_value) AS price ,ac_date AS date ,SUM(ac_salary) AS money FROM achievements WHERE ac_depart = #{depart} and ac_team = #{team} GROUP BY ac_date ;")
    List<PerformanceOfTheCombinedDepartAndTeamAndPost> getCombinedByDepartAndTeamAllPost(String depart,String team);


    //获取某个部门某个科室某个岗位的绩效奖金
    @Select("SELECT ac_post as post ,ac_team as team ,ac_depart as depart,SUM(ac_value) AS price ,ac_date AS date ,SUM(ac_salary) AS money FROM achievements WHERE ac_depart = #{depart} and ac_team = #{team} and ac_post = #{post} GROUP BY ac_date ;")
    List<PerformanceOfTheCombinedDepartAndTeamAndPost> getCombinedByDepartAndTeamAndPost(String depart,String team,String post);



}
