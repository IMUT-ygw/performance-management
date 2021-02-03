package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;


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


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String getpHospital() {
        return pHospital;
    }

    public void setpHospital(String pHospital) {
        this.pHospital = pHospital;
    }

    public String getpDepartment() {
        return pDepartment;
    }

    public void setpDepartment(String pDepartment) {
        this.pDepartment = pDepartment;
    }

    public String getpPost() {
        return pPost;
    }

    public void setpPost(String pPost) {
        this.pPost = pPost;
    }

    public String getpTeam() {
        return pTeam;
    }

    public void setpTeam(String pTeam) {
        this.pTeam = pTeam;
    }

    public Double getpSalary() {
        return pSalary;
    }

    public void setpSalary(Double pSalary) {
        this.pSalary = pSalary;
    }

    public Integer getpGender() {
        return pGender;
    }

    public void setpGender(Integer pGender) {
        this.pGender = pGender;
    }

    public String getpPwd() {
        return pPwd;
    }

    public void setpPwd(String pPwd) {
        this.pPwd = pPwd;
    }

    @Override
    public String toString() {
        return "PersonnelManagement{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pPhone='" + pPhone + '\'' +
                ", pHospital='" + pHospital + '\'' +
                ", pDepartment='" + pDepartment + '\'' +
                ", pPost='" + pPost + '\'' +
                ", pTeam='" + pTeam + '\'' +
                ", pSalary=" + pSalary +
                ", pGender=" + pGender +
                ", pwd='" + pPwd + '\'' +
                '}';
    }
}
