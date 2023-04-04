package com.loan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.loan.common.annotation.Excel;
import com.loan.common.core.domain.BaseEntity;

/**
 * 银行对象 stu_bank
 * 
 * @author loan
 * @date 2023-04-04
 */
public class StuBank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 银行id */
    private Long bankId;

    /** 银行名字 */
    @Excel(name = "银行名字")
    private String bankName;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updater;

    public void setBankId(Long bankId) 
    {
        this.bankId = bankId;
    }

    public Long getBankId() 
    {
        return bankId;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
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
            .append("bankId", getBankId())
            .append("bankName", getBankName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("creator", getCreator())
            .append("updater", getUpdater())
            .toString();
    }
}
