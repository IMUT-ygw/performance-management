package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.PersonnelManagement;
import com.abc.performancemanagement.pojo.ResultMsg;
import com.abc.performancemanagement.service.AchievementsService;
import com.abc.performancemanagement.service.PerformanceService;
import com.abc.performancemanagement.service.PersonnelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnelManagement")
public class PersonnelManagementController {

    @Autowired
    private PersonnelManagementService personnelManagementService;

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private AchievementsService achievementsService;

    @PostMapping("/addUser")
    public Object addUser(@RequestBody PersonnelManagement personnelManagement){
        System.out.println("添加人员："+personnelManagement);
        Integer all= personnelManagementService.addUser(personnelManagement);
        if(all < 1){
            return new ResultMsg<Object>(400,"添加失败！",null);
        }
        return new ResultMsg<Object>(200,"添加成功！",personnelManagement);
    }


    @GetMapping("/getAll")
    public Object getAll(){
        List<PersonnelManagement> all = personnelManagementService.getAll();
        if(all.size() < 1){
            return new ResultMsg<Object>(400,"获取失败！",null);
        }
        return new ResultMsg<Object>(200,"获取成功！",all);
    }

    //员工登录
    @PostMapping("/login")
    public Object login(@RequestBody PersonnelManagement personnelManagement){
        System.out.println(personnelManagement);
        PersonnelManagement login = personnelManagementService.login(personnelManagement);
        if(login !=null){
            return new ResultMsg<PersonnelManagement>(200,"登录成功！",login);
        }
        return  new ResultMsg<PersonnelManagement>(400,"登录失败，请检查用户名及密码！",null);
    }

    //管理员登录
    @PostMapping("/adminLogin")
    public Object adminLogin(@RequestBody PersonnelManagement personnelManagement){
        System.out.println(personnelManagement);
        if("admin".equals(personnelManagement.getpId()) || "admin".equals(personnelManagement.getpPwd())){
            return new ResultMsg<String>(200,"登录成功！","管理员登录");
        }
        return  new ResultMsg<String>(400,"登录失败，请检查用户名及密码！",null);
    }


    @PostMapping("/userUpdate")
    public Object userUpdate(@RequestBody PersonnelManagement personnelManagement){
        Integer integer = personnelManagementService.userUpdate(personnelManagement);
        if (integer < 1) {
            return new ResultMsg<Object>(400, "更新失败", null);
        }
        return new ResultMsg<Object>(200, "更新成功，更新条数：" + integer, null);
    }


    @PostMapping("/adminUpdate")
    public Object adminUpdate(@RequestBody PersonnelManagement personnelManagement){
        Integer integer = personnelManagementService.adminUpdate(personnelManagement);
        if (integer < 1) {
            return new ResultMsg<Object>(400, "更新失败", null);
        }
        return new ResultMsg<Object>(200, "更新成功，更新条数：" + integer, null);
    }

    @PostMapping("/adminDelete")
    public Object adminDelete(@RequestBody PersonnelManagement personnelManagement){
        String pId = personnelManagement.getpId();
        Integer a = personnelManagementService.deleteUser(pId);
        Integer b = achievementsService.deleteUser(pId);
        Integer c = performanceService.deleteUser(pId);
        return new ResultMsg<Object>(200,"删除总条数：" + a + b + c,"ps:删除信息包含员工信息，员工绩效信息，员工奖金信息");
    }


}
