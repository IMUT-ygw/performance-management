package com.abc.performancemanagement.controller;

import com.abc.performancemanagement.pojo.Credit;
import com.abc.performancemanagement.pojo.Post;
import com.abc.performancemanagement.pojo.ResultMsg;
import com.abc.performancemanagement.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    //获取全部加分项
    @GetMapping("/getAllCredit")
    public Object getAllCredit(){
        List<Credit> all = creditService.getAll();
        if(all.size() < 1){
            return new ResultMsg<Object>(400,"加分项数据为空！",null);
        }
        return new ResultMsg<Object>(200,"加分项数据获取成功！总数：" + all.size(),all);
    }

    //添加加分项
    @PostMapping("/addCredit")
    public Object addCredit(@RequestBody Credit credit){
        HashMap<String,Integer> price = new HashMap<>();
        price.put("医务部",500);
        price.put("后勤部",200);
        price.put("行政部",400);
        price.put("技术部",300);
        price.put("人事部",100);
        credit.setCPrice(price.get(credit.getCDepart()));
        Integer integer = creditService.addCredit(credit);
        if (integer < 1) {
                return new ResultMsg<Object>(400, "添加失败", null);
            }
            return new ResultMsg<Object>(200, "添加成功，添加条数：" + integer, null);
    }
}
