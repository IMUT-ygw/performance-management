package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.PersonnelManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 员工基础管理
 */
@Mapper
public interface PersonnelManagementMapper {

    //获取全部员信息
    @Select("select * from personnelmanagement")
    List<PersonnelManagement> getAll();


    //员工登录
    @Select("select * from personnelmanagement where p_id = #{pId} and p_pwd = #{pPwd}")
    PersonnelManagement login(PersonnelManagement personnelManagement);

    @Insert("insert into personnelmanagement(p_id,p_name,p_phone,p_hospital,p_department,p_post,p_team,p_salary,p_gender,p_pwd) values(#{pId},#{pName},#{pPhone},#{pHospital},#{pDepartment},#{pPost},#{pTeam},#{pSalary},#{pGender},#{pPwd})")
    Integer addUser(PersonnelManagement personnelManagement);

    //员工修改
    @Update({"<script>",
            "update personnelmanagement",
            "<set>",
            "<if test='pName != null'>",
            "p_name = #{pName} ,",
            "</if>",
            "<if test='pPhone != null'>",
            "p_phone = #{pPhone} ,",
            "</if>",
            "<if test='pPwd != null'>",
            "p_pwd = #{pPwd} ,",
            "</if>",
            "</set>",
            "where p_id = #{pId}",
            "</script>"})
    Integer userUpdate(PersonnelManagement personnelManagement);




    @Update({"<script>",
            "update personnelmanagement",
            "<set>",
            "<if test='pName != null'>",
            "p_name = #{pName} ,",
            "</if>",
            "<if test='pPhone != null'>",
            "p_phone = #{pPhone} ,",
            "</if>",
            "<if test='pPwd != null'>",
            "p_pwd = #{pPwd} ,",
            "</if>",
            "<if test='pDepartment != null'>",
            "p_department = #{pDepartment} ,",
            "</if>",
            "<if test='pPost != null'>",
            "p_post = #{pPost} ,",
            "</if>" ,
            "<if test='pTeam != null'>",
            "p_team = #{pTeam} ,",
            "</if>" ,
            "<if test='pSalary != null'>",
            "p_salary = #{pSalary} ,",
            "</if>" ,
            "</set>",
            "where p_id = #{pId}",
            "</script>"})
    Integer adminUpdate(PersonnelManagement personnelManagement);


    @Delete("delete from personnelmanagement where p_id = #{pId}")
    Integer deleteUser(String pId);
}
