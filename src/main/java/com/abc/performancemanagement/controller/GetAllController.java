package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.Post;
import com.abc.performancemanagement.pojo.ResultMsg;
import com.abc.performancemanagement.pojo.Team;
import com.abc.performancemanagement.service.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/getTeam")
    public Object getTeam(){
        List<Team> teamAll = getAllService.getTeamAll();
        if(teamAll.size() < 1){
            return new ResultMsg<Object>(400,"班组数据为空！",null);
        }
        return new ResultMsg<Object>(200,"班组数据获取成功！总数：" + teamAll.size(),teamAll);
    }


    @GetMapping("/getPost")
    public Object getPost(){
        List<Post> postAll = getAllService.getPostAll();
        if(postAll.size() < 1){
            return new ResultMsg<Object>(400,"岗位数据为空！",null);
        }
        return new ResultMsg<Object>(200,"岗位数据获取成功！总数：" + postAll.size(),postAll);
    }

    @PostMapping("/addDepart")
    public Object addDepart(@RequestBody Department department){
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
