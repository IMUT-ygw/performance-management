package com.abc.performancemanagement.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

//岗位
@AllArgsConstructor
@Data
public class Post {
    private String poId; //部门id
    private String poName; //部门名
    private String poDepartment; //所属部门
}
