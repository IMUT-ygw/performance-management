package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.PersonnelManagementMapper;
import com.abc.performancemanagement.pojo.PersonnelManagement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelManagementService {

    @Autowired
    private PersonnelManagementMapper personnelManagementMapper;

    //员工登录
    public PersonnelManagement login(PersonnelManagement personnelManagement){
        PersonnelManagement login = personnelManagementMapper.login(personnelManagement);
        if(login !=null){
            return login;
        }
        return null;
    }

    //员工修改
    public Integer userUpdate(PersonnelManagement personnelManagement){
        return personnelManagementMapper.userUpdate(personnelManagement);
    }


    //管理员修改
    public Integer adminUpdate(PersonnelManagement personnelManagement){
        return personnelManagementMapper.adminUpdate(personnelManagement);
    }


    public List<PersonnelManagement> getAll(){
           return  personnelManagementMapper.getAll();
    }

}
