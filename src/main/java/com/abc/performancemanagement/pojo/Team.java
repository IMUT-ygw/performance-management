package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

//班组
@AllArgsConstructor
@Data
public class Team {
    private String tId; //班组id
    private String tName; //班组名
    private String tDepartment; //所属部门

}
