package com.loan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 学院管理对象 stu_college
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuCollege extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学院ID */
    private Long collegeId;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String name;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 学生人数 */
    @Excel(name = "学生人数")
    private Long totalStudents;

    /** 贷款人数 */
    @Excel(name = "贷款人数")
    private Long totalBorrowers;

    /** 上交合同数 */
    @Excel(name = "上交合同数")
    private Long totalContracts;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updater;

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
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
            .append("collegeId", getCollegeId())
            .append("name", getName())
            .append("creator", getCreator())
            .append("totalStudents", getTotalStudents())
            .append("totalBorrowers", getTotalBorrowers())
            .append("totalContracts", getTotalContracts())
            .append("createTime", getCreateTime())
            .append("updater", getUpdater())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
