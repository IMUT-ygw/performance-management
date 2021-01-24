package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

//员工工作描述
@AllArgsConstructor
@Data
public class Performance {

    private Integer perId;
    private Integer perKind; //加分还是减分
    private Double perValue; //分值
    private Date perDate; //加减分日期
    private String perDescribe; //加减分描述
    private String perUser; //所属人

}
