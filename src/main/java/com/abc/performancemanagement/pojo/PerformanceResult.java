package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

//绩点信息封装
@AllArgsConstructor
@Data
public class PerformanceResult {

    private String user;
    private String date;
    private Double value;



}
