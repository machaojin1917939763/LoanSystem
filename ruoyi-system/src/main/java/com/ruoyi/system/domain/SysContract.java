package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_contract
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public class SysContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String contractUrl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String academicYear;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long studentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal loanAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal tuitionFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date deductionDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date disbursementDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String bankName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String designatedAccount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String verificationCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String idCardNumber;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String creator;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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
