package com.loan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 客户信息管理对象 stu_customer
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户信息ID */
    private Long customerId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 学号 */
    @Excel(name = "学号")
    private String studentId;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 共同借款人姓名 */
    @Excel(name = "共同借款人姓名")
    private String coBorrowerName;
    @Excel(name = "共同借款人身份证号")
    private String coBorrowerNameId;
    @Excel(name = "身份证号")
    private String idCard;

    /** 所属班级ID */
    @Excel(name = "所属班级ID")
    private Long classId;
    @Excel(name = "所属学院")
    private Long collegeId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updater;
    @Excel(name = "电子邮件")
    private String email;
    @Excel(name = "电话号码")
    private String phone;

    public String getEmail() {
        return email;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    @Override
    public String toString() {
        return "StuCustomer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", studentId='" + studentId + '\'' +
                ", address='" + address + '\'' +
                ", coBorrowerName='" + coBorrowerName + '\'' +
                ", coBorrowerNameId='" + coBorrowerNameId + '\'' +
                ", idCard='" + idCard + '\'' +
                ", classId=" + classId +
                ", collegeId=" + collegeId +
                ", creator='" + creator + '\'' +
                ", updater='" + updater + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", majorId='" + majorId + '\'' +
                '}';
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCoBorrowerNameId() {
        return coBorrowerNameId;
    }

    public void setCoBorrowerNameId(String coBorrowerNameId) {
        this.coBorrowerNameId = coBorrowerNameId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    @Excel(name = "年级id")
    private String gradeId;
    @Excel(name = "专业id")
    private String majorId;

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setCoBorrowerName(String coBorrowerName) 
    {
        this.coBorrowerName = coBorrowerName;
    }

    public String getCoBorrowerName() 
    {
        return coBorrowerName;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setUpdater(String updater) 
    {
        this.updater = updater;
    }

    public String getUpdater() 
    {
        return updater;
    }

}
