package com.abc.performancemanagement.service;

import com.abc.performancemanagement.mapper.CreditMapper;
import com.abc.performancemanagement.pojo.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditMapper creditMapper;


    public List<Credit> getAll(){
        return creditMapper.getAll();
    }

    public Integer addCredit(Credit credit){
        return creditMapper.addCredit(credit);
    }

    //获取某个部门的绩点钱数
    public List<Credit> getPrice(String depart){
        return creditMapper.getPrice(depart);
    }
}
