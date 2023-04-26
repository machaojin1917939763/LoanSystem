package com.loan.system.domain.vo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class PactVo implements Serializable {
    public static final long SerializableID = 1L;
    private String account;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    private String loanAmount;
    private String bank;
    private String banji;
    private String college;
    private List<File> fileList;
    private String grade;
    private String idcard;
    private String major;
    private String money;
    private String name;
    private String number;
    private String school;
    private String sex;
    private String time;

    @Override
    public String toString() {
        return "PactVo{" +
                "account='" + account + '\'' +
                ", bank='" + bank + '\'' +
                ", banji='" + banji + '\'' +
                ", college='" + college + '\'' +
                ", fileList=" + fileList +
                ", grade='" + grade + '\'' +
                ", idcard='" + idcard + '\'' +
                ", major='" + major + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", school='" + school + '\'' +
                ", sex='" + sex + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
