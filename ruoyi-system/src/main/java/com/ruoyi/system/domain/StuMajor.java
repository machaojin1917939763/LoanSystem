package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专业管理对象 stu_major
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
public class StuMajor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业ID */
    private Long majorId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String name;

    /** 所属学院ID */
    @Excel(name = "所属学院ID")
    private Long collegeId;

    /** 专业总人数 */
    @Excel(name = "专业总人数")
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

    public void setMajorId(Long majorId) 
    {
        this.majorId = majorId;
    }

    public Long getMajorId() 
    {
        return majorId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
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
            .append("majorId", getMajorId())
            .append("name", getName())
            .append("collegeId", getCollegeId())
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
