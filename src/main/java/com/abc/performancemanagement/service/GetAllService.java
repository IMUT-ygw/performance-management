package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.DepartmentMapper;
import com.abc.performancemanagement.mapper.PostMapper;
import com.abc.performancemanagement.mapper.TeamMapper;
import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.Post;
import com.abc.performancemanagement.pojo.Team;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//涵盖部门、班组、岗位的全部数据及添加
@Service
public class GetAllService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private PostMapper postMapper;

    //部门
    public List<Department> getDepartAll(){
        return departmentMapper.getAll();
    }

    //岗位
    public List<Post> getPostAll(){
        return postMapper.getAll();
    }

    //班组
    public List<Team> getTeamAll(){
        return teamMapper.getAll();
    }

    //部门添加
    public Integer addDepart(Department department){
        return departmentMapper.addDepartment(department);
    }

    //岗位添加
    public Integer addPost(Post post){
        return postMapper.addPost(post);
    }

    //班组添加
    public Integer addTeam(Team team){
        return teamMapper.addTeam(team);
    }


    public Boolean getByIdDepart(String dId,String name){
        Department byId = departmentMapper.getById(dId,name);
        if(byId != null){
            return false;
        }
        return true;
    }

    public Boolean getByIdPost(String dId,String name){
        Post byId = postMapper.getById(dId,name);
        if(byId != null){
            return false;
        }
        return true;
    }


    public Boolean getByIdTeam(String dId,String name){
        Team byId = teamMapper.getById(dId,name);
        if(byId != null){
            return false;
        }
        return true;
    }


}
