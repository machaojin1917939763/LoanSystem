package com.loan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 班级管理对象 stu_class
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级ID */
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String name;

    /** 所属年级ID */
    @Excel(name = "所属年级ID")
    private Long gradeId;

    /** 班级总人数 */
    @Excel(name = "班级总人数")
    private Long totalStudents;

    /** 贷款总人数 */
    @Excel(name = "贷款总人数")
    private Long totalBorrowers;

    /** 上交合同数 */
    @Excel(name = "上交合同数")
    private Long totalContracts;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updater;

    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
    }
    public void setTotalStudents(Long totalStudents) 
    {
        this.totalStudents = totalStudents;
    }

    public Long getTotalStudents() 
    {
        return totalStudents;
    }
    public void setTotalBorrowers(Long totalBorrowers) 
    {
        this.totalBorrowers = totalBorrowers;
    }

    public Long getTotalBorrowers() 
    {
        return totalBorrowers;
    }
    public void setTotalContracts(Long totalContracts) 
    {
        this.totalContracts = totalContracts;
    }

    public Long getTotalContracts() 
    {
        return totalContracts;
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
            .append("classId", getClassId())
            .append("name", getName())
            .append("gradeId", getGradeId())
            .append("totalStudents", getTotalStudents())
            .append("totalBorrowers", getTotalBorrowers())
            .append("totalContracts", getTotalContracts())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("updater", getUpdater())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
