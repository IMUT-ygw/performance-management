package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Achievements;
import com.abc.performancemanagement.pojo.PersonnelManagement;
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



}
