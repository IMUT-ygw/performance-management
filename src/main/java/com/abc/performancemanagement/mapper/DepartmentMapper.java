package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//部门列表
@Mapper
public interface DepartmentMapper {

    //获取所有部门信息
    @Select("select * from department")
    List<Department> getAll();


    //管理员添加部门信息
    @Insert("insert into department values(#{dId},#{dName})")
    @Options(keyColumn = "d_id",keyProperty = "dId",useGeneratedKeys = true)
    Integer addDepartment(Department department);


    //添加信息防止id重复
    @Select("select * from department where d_id = #{dId} or d_name = #{dName}")
    Department getById(String dId,String dName);
}
