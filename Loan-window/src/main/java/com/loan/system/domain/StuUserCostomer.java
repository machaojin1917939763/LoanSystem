package com.loan.system.domain;

import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 stu_user_costomer
 * 
 * @author loan
 * @date 2023-04-27
 */
public class StuUserCostomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id
 */
    private Long id;

    /** 系统用户 */
    @Excel(name = "系统用户")
    private Long userId;

    /** 注册用户 */
    @Excel(name = "注册用户")
    private Long studentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("studentId", getStudentId())
            .toString();
    }
}
