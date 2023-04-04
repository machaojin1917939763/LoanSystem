package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 年级管理对象 stu_grade
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
public class StuGrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年级ID */
    private Long gradeId;

    /** 年级名称 */
    @Excel(name = "年级名称")
    private String name;

    /** 所属专业ID */
    @Excel(name = "所属专业ID")
    private Long majorId;

    /** 年级总人数 */
    @Excel(name = "年级总人数")
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

    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMajorId(Long majorId) 
    {
        this.majorId = majorId;
    }

    public Long getMajorId() 
    {
        return majorId;
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
            .append("gradeId", getGradeId())
            .append("name", getName())
            .append("majorId", getMajorId())
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
