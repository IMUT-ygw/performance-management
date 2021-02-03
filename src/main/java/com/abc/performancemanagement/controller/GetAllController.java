package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.*;
import com.abc.performancemanagement.service.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/getAll")
public class GetAllController {

    @Autowired
    private GetAllService getAllService;

    @GetMapping("/getDepart")
    public Object getDepart(){
        List<Department> departAll = getAllService.getDepartAll();
        if(departAll.size() < 1){
            return new ResultMsg<Object>(400,"部门数据为空！",null);
        }
        return new ResultMsg<Object>(200,"部门数据获取成功！总数：" + departAll.size(),departAll);
    }


    @PostMapping("/getTeam")
    public Object getTeam(@RequestBody PersonnelManagement personnelManagement){
        List<Team> teamAll = getAllService.getTeamAll(personnelManagement.getpDepartment());
        if(teamAll.size() < 1){
            return new ResultMsg<Object>(400,"班组数据为空！",null);
        }
        return new ResultMsg<Object>(200,"班组数据获取成功！总数：" + teamAll.size(),teamAll);
    }


    @PostMapping("/getPost")
    public Object getPost(@RequestBody PersonnelManagement personnelManagement){
        List<Post> postAll = getAllService.getPostAll(personnelManagement.getpDepartment());
        if(postAll.size() < 1){
            return new ResultMsg<Object>(400,"岗位数据为空！",null);
        }
        return new ResultMsg<Object>(200,"岗位数据获取成功！总数：" + postAll.size(),postAll);
    }

    @PostMapping("/addDepart")
    public Object addDepart(@RequestBody Department department){
        String uuid = UUID.randomUUID().toString();
        department.setDId(uuid);
        if(getAllService.getByIdDepart(department.getDId(),department.getDName())) {
            Integer integer = getAllService.addDepart(department);
            if (integer < 1) {
                return new ResultMsg<Object>(400, "添加失败", null);
            }
            return new ResultMsg<Object>(200, "添加成功，添加条数：" + integer, null);
        }
        return new ResultMsg<Object>(404, "编号或部门已存在!", null);
    }

    @PostMapping("/addPost")
    public Object addPost(@RequestBody Post post){
        String uuid = UUID.randomUUID().toString();
        post.setPoId(uuid);
        if(getAllService.getByIdPost(post.getPoId(),post.getPoName())) {
            Integer integer = getAllService.addPost(post);
            if (integer < 1) {
                return new ResultMsg<Object>(400, "添加失败", null);
            }
            return new ResultMsg<Object>(200, "添加成功，添加条数：" + integer, null);
        }
        return new ResultMsg<Object>(404, "编号或部门已存在！", null);
    }


    @PostMapping("/addTeam")
    public Object addTeam(@RequestBody Team team){
        String uuid = UUID.randomUUID().toString();
        team.setTId(uuid);
        if(getAllService.getByIdTeam(team.getTId(),team.getTName())) {
            Integer integer = getAllService.addTeam(team);
            if (integer < 1) {
                return new ResultMsg<Object>(400, "添加失败", null);
            }
            return new ResultMsg<Object>(200, "添加成功，添加条数：" + integer, null);
        }
        return new ResultMsg<Object>(404,  "编号或部门已存在！", null);
    }


}
