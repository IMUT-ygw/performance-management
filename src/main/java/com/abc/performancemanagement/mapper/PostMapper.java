package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    //获取所有部门信息
    @Select("select * from post where po_department = #{poDepartment}")
    List<Post> getAll(String poDepartment );


    //管理员添加部门信息
    @Insert("insert into post values(#{poId},#{poName},#{poDepartment})")
    @Options(keyColumn = "po_id",keyProperty = "poId",useGeneratedKeys = true)
    Integer addPost(Post post);


    @Select("select * from post where po_id = #{poId} or po_name = #{poName}")
    Post getById(String poId,String poName);


}
