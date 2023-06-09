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

    @Excel(name = "校验码")
    private String codeUrl;

    /** 学年 */
    @Excel(name = "学年")
    private String academicYear;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 贷款金额 */
    @Excel(name = "贷款金额")
    private BigDecimal loanAmount;

    /** 是否放款 */
    @Excel(name = "是否放款")
    private String isDisbursed;

    /** 放款银行ID */
    @Excel(name = "放款银行")
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

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
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
    public void setIsDisbursed(String isDisbursed)
    {
        this.isDisbursed = isDisbursed;
    }

    public String getIsDisbursed()
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StuContract{" +
                "id=" + id +
                ", contractUrl='" + contractUrl + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", loanAmount=" + loanAmount +
                ", isDisbursed='" + isDisbursed + '\'' +
                ", bankId=" + bankId +
                ", tuitionFee=" + tuitionFee +
                ", deductionDate=" + deductionDate +
                ", disbursementDate=" + disbursementDate +
                ", bankName='" + bankName + '\'' +
                ", designatedAccount='" + designatedAccount + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", creator='" + creator + '\'' +
                ", updater='" + updater + '\'' +
                '}';
    }
}
