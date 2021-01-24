package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonnelManagement {
    private String pId; //工号 20201101累加
    private String pName;  //姓名
    private String pPhone; //联系方式
    private String pHospital;  //医院
    private String pDepartment; //部门
    private String pPost;    //岗位
    private String pTeam;    //班组
    private Double pSalary;  //底薪
    private Integer pGender; //性别
    private String pPwd; //密码




}
