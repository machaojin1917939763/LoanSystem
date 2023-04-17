package com.loan.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 合同信息管理对象 stu_contract
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同ID */
    private Long id;

    /** 合同URL */
    @Excel(name = "合同")
    private String contractUrl;

    /** 学年 */
    @Excel(name = "学年")
    private String academicYear;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 贷款金额 */
    @Excel(name = "贷款金额")
    private BigDecimal loanAmount;

    /** 是否放款 */
    @Excel(name = "是否放款")
    private Integer isDisbursed;

    /** 放款银行ID */
    @Excel(name = "放款银行ID")
    private Long bankId;

    /** 学费 */
    @Excel(name = "学费")
    private BigDecimal tuitionFee;

    /** 扣款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "扣款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deductionDate;

    /** 放款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "放款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date disbursementDate;

    /** 银行名称 */
    @Excel(name = "银行名称")
    private String bankName;

    /** 指定账户 */
    @Excel(name = "指定账户")
    private String designatedAccount;

    /** 验证码 */
    @Excel(name = "验证码")
    private String verificationCode;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCardNumber;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updater;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContractUrl(String contractUrl) 
    {
        this.contractUrl = contractUrl;
    }

    public String getContractUrl() 
    {
        return contractUrl;
    }
    public void setAcademicYear(String academicYear) 
    {
        this.academicYear = academicYear;
    }

    public String getAcademicYear() 
    {
        return academicYear;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setLoanAmount(BigDecimal loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanAmount() 
    {
        return loanAmount;
    }
    public void setIsDisbursed(Integer isDisbursed) 
    {
        this.isDisbursed = isDisbursed;
    }

    public Integer getIsDisbursed() 
    {
        return isDisbursed;
    }
    public void setBankId(Long bankId) 
    {
        this.bankId = bankId;
    }

    public Long getBankId() 
    {
        return bankId;
    }
    public void setTuitionFee(BigDecimal tuitionFee) 
    {
        this.tuitionFee = tuitionFee;
    }

    public BigDecimal getTuitionFee() 
    {
        return tuitionFee;
    }
    public void setDeductionDate(Date deductionDate) 
    {
        this.deductionDate = deductionDate;
    }

    public Date getDeductionDate() 
    {
        return deductionDate;
    }
    public void setDisbursementDate(Date disbursementDate) 
    {
        this.disbursementDate = disbursementDate;
    }

    public Date getDisbursementDate() 
    {
        return disbursementDate;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setDesignatedAccount(String designatedAccount) 
    {
        this.designatedAccount = designatedAccount;
    }

    public String getDesignatedAccount() 
    {
        return designatedAccount;
    }
    public void setVerificationCode(String verificationCode) 
    {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode() 
    {
        return verificationCode;
    }
    public void setIdCardNumber(String idCardNumber) 
    {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardNumber() 
    {
        return idCardNumber;
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
            .append("id", getId())
            .append("contractUrl", getContractUrl())
            .append("academicYear", getAcademicYear())
            .append("studentId", getStudentId())
            .append("loanAmount", getLoanAmount())
            .append("isDisbursed", getIsDisbursed())
            .append("bankId", getBankId())
            .append("tuitionFee", getTuitionFee())
            .append("deductionDate", getDeductionDate())
            .append("disbursementDate", getDisbursementDate())
            .append("bankName", getBankName())
            .append("designatedAccount", getDesignatedAccount())
            .append("verificationCode", getVerificationCode())
            .append("idCardNumber", getIdCardNumber())
            .append("creator", getCreator())
            .append("createTime", getCreateTime())
            .append("updater", getUpdater())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
