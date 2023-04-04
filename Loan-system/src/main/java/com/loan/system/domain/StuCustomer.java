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

    /** 所属班级ID */
    @Excel(name = "所属班级ID")
    private Long classId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updater;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("name", getName())
            .append("sex", getSex())
            .append("studentId", getStudentId())
            .append("address", getAddress())
            .append("coBorrowerName", getCoBorrowerName())
            .append("classId", getClassId())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("updater", getUpdater())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
