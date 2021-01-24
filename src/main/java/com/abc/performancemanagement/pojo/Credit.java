package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

//加分项
@AllArgsConstructor
@Data
public class Credit {
    private Integer cId;
    private String cName; //加分项名称
    private Integer cBranch; //每个加分项值多少绩点
    private Integer cPrice; //本次加分工资多少
    private String cDepart; //所属部门
}
