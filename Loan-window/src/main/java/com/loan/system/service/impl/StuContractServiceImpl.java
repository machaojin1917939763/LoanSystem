package com.loan.system.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.loan.common.core.domain.entity.SysUser;
import com.loan.common.utils.DateUtils;
import com.loan.system.domain.StuBank;
import com.loan.system.domain.StuCustomer;
import com.loan.system.domain.vo.PactVo;
import com.loan.system.mapper.StuBankMapper;
import com.loan.system.service.IStuCustomerService;
import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuContractMapper;
import com.loan.system.domain.StuContract;
import com.loan.system.service.IStuContractService;

import javax.servlet.http.Cookie;

/**
 * 合同信息管理Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuContractServiceImpl implements IStuContractService 
{
    @Autowired
    private StuContractMapper stuContractMapper;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private IStuCustomerService stuCustomerService;

    @Autowired
    private StuBankMapper bankMapper;

    /**
     * 查询合同信息管理
     * 
     * @param id 合同信息管理主键
     * @return 合同信息管理
     */
    @Override
    public StuContract selectStuContractById(Long id)
    {
        return stuContractMapper.selectStuContractById(id);
    }

    /**
     * 查询合同信息管理列表
     * 
     * @param stuContract 合同信息管理
     * @return 合同信息管理
     */
    @Override
    public List<StuContract> selectStuContractList(StuContract stuContract)
    {
        List<StuContract> list = stuContractMapper.selectStuContractList(stuContract);
        for (StuContract item : list){

            StuCustomer stuCustomer = stuCustomerService.selectStuCustomerByCustomerId(item.getStudentId());
            item.setStudentName(stuCustomer.getName());
        }
        return list;
    }

    /**
     * 新增合同信息管理
     * 
     * @param stuContract 合同信息管理
     * @return 结果
     */
    @Override
    public int insertStuContract(StuContract stuContract)
    {
        stuContract.setCreateTime(DateUtils.getNowDate());
        return stuContractMapper.insertStuContract(stuContract);
    }

    /**
     * 修改合同信息管理
     * 
     * @param stuContract 合同信息管理
     * @return 结果
     */
    @Override
    public int updateStuContract(StuContract stuContract)
    {
        stuContract.setUpdateTime(DateUtils.getNowDate());
        return stuContractMapper.updateStuContract(stuContract);
    }

    /**
     * 批量删除合同信息管理
     * 
     * @param ids 需要删除的合同信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuContractByIds(Long[] ids)
    {
        return stuContractMapper.deleteStuContractByIds(ids);
    }

    /**
     * 删除合同信息管理信息
     * 
     * @param id 合同信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuContractById(Long id)
    {
        return stuContractMapper.deleteStuContractById(id);
    }

    /**
     * 合同上传
     *
     * @param pactVo  合同信息
     * @param cookies
     * @return 结果
     */
    @Override
    public int addContract(PactVo pactVo, Cookie[] cookies) throws ParseException {
        StuContract stuContract = new StuContract();
        //银行
        stuContract.setBankId(Long.parseLong(pactVo.getBank()));
        stuContract.setAcademicYear(new SimpleDateFormat("yyyy").format(new Date()));
        String username = "student";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                username = cookie.getName();
            }
        }
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        stuContract.setStudentId(sysUser.getUserId());
        stuContract.setLoanAmount(new BigDecimal(pactVo.getMoney()));
        stuContract.setIsDisbursed(1);
        StuBank stuBank = bankMapper.selectStuBankByBankId(Long.parseLong(pactVo.getBank()));
        stuContract.setBankId(stuBank.getBankId());
        stuContract.setBankName(stuBank.getBankName());
        stuContract.setDeductionDate(new SimpleDateFormat().parse("2100-12-12"));
        stuContract.setDisbursementDate(new SimpleDateFormat().parse("2100-12-12"));
        stuContract.setLoanAmount(new BigDecimal(pactVo.getMoney()));
        stuContract.setIdCardNumber(pactVo.getIdcard());
        stuContract.setVerificationCode(pactVo.getLoanAmount());
        return stuContractMapper.insertStuContract(stuContract);
    }
}
