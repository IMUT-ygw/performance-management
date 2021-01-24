package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResultMsg<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultMsg(Integer code,String msg){
        this(code,msg,null);
    }
}
