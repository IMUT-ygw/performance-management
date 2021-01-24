package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.Post;
import com.abc.performancemanagement.pojo.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper {

    //获取所有部门信息
    @Select("select * from team")
    List<Team> getAll();

    //管理员添加部门信息
    @Insert("insert into team values(#{tId},#{tName},#{tDepartment})")
    @Options(keyColumn = "t_id",keyProperty = "tId",useGeneratedKeys = true)
    Integer addTeam(Team team);

    @Select("select * from team where t_id = #{tId} or t_name = #{tName}")
    Team getById(String tId,String tName);
}
