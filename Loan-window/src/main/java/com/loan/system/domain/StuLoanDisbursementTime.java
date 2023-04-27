package com.loan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 放款时间对象 stu_loan_disbursement_time
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuLoanDisbursementTime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 时间id */
    private Long timeId;

    /** 学年id */
    @Excel(name = "学年id")
    private String academicYearId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "银行")
    private String bankId;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "StuLoanDisbursementTime{" +
                "timeId=" + timeId +
                ", academicYearId='" + academicYearId + '\'' +
                ", creator='" + creator + '\'' +
                ", bankId='" + bankId + '\'' +
                ", updater='" + updater + '\'' +
                '}';
    }

    /** 修改人 */
    @Excel(name = "修改人")
    private String updater;

    public void setTimeId(Long timeId) 
    {
        this.timeId = timeId;
    }

    public Long getTimeId() 
    {
        return timeId;
    }
    public void setAcademicYearId(String academicYearId)
    {
        this.academicYearId = academicYearId;
    }

    public String getAcademicYearId()
    {
        return academicYearId;
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
