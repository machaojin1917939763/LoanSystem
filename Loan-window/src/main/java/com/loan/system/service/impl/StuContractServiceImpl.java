package com.loan.system.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import com.loan.common.core.domain.entity.SysUser;
import com.loan.common.core.domain.model.LoginUser;
import com.loan.common.utils.DateUtils;
import com.loan.system.domain.StuBank;
import com.loan.system.domain.StuCustomer;
import com.loan.system.domain.SysUserRole;
import com.loan.system.domain.vo.PactVo;
import com.loan.system.mapper.*;
import com.loan.system.service.IStuCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.domain.StuContract;
import com.loan.system.service.IStuContractService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 合同信息管理Service业务层处理
 *
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuContractServiceImpl implements IStuContractService {
    @Autowired
    private StuContractMapper stuContractMapper;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private IStuCustomerService stuCustomerService;

    @Autowired
    private StuBankMapper bankMapper;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private StuCustomerMapper stuCustomerMapper;

    @Autowired
    private StuBankMapper stuBankMapper;

    @Autowired
    private TokenUtils tokenUtils;

    /**
     * 查询合同信息管理
     *
     * @param id 合同信息管理主键
     * @return 合同信息管理
     */
    @Override
    public StuContract selectStuContractById(Long id) {
        return stuContractMapper.selectStuContractById(id);
    }

    /**
     * 查询合同信息管理列表
     *
     * @param stuContract 合同信息管理
     * @param request
     * @return 合同信息管理
     */
    @Override
    public List<StuContract> selectStuContractList(StuContract stuContract, HttpServletRequest request) {
        List<StuContract> list = stuContractMapper.selectStuContractList(stuContract);
        for (StuContract item : list) {
            StuCustomer stuCustomer = stuCustomerService.selectStuCustomerByCustomerId(item.getStudentId());
            if (stuCustomer != null) {
                item.setStudentName(stuCustomer.getName());
            }
        }
        LoginUser loginUser = tokenUtils.getLoginUser(request);
        String username = loginUser.getUsername();

        //根据cookie中的用户查询
        //1、先拿到username，查询出这个人的信息
        SysUser sysUser = userMapper.selectUserByUserName(username);
        StuCustomer stuCustomer = stuCustomerMapper.selectStuCustomerByName(username);
        List<SysUserRole> sysUserRoles = userRoleMapper.selectByUserId(sysUser.getUserId().toString());

        AtomicBoolean flag = new AtomicBoolean(false);
        if (sysUserRoles != null && sysUserRoles.size() > 0) {
            sysUserRoles.forEach((value -> {
                if (value.getRoleId().toString().equals("105")) {
                    flag.set(true);
                }
            }));
        }
        //如果是学生
        if (flag.get()) {
/*            return list.stream().filter((value) -> {
                return value.getStudentId().toString().equals(sysUser.getUserId().toString());
            }).collect(Collectors.toList());
            //校方人员*/
            for (StuContract item : list) {
                if (sysUser.getUserId().toString().equals(item.getStudentId())) {
                    return Collections.singletonList(item);
                }
            }
            return null;
        } else {
            switch (sysUser.getUserName()) {
                case "college": {
                    //根据学院id查询所有的学生
                    List<StuCustomer> customers = stuCustomerMapper.selectStuCustomerByCollegeId(stuCustomer.getCollegeId());
                    //根据学生查询所有的合同
                    return getStuContracts(list, sysUser, customers);
                }
                case "major": {
                    //根据专业id查询所有的学生
                    List<StuCustomer> customers = stuCustomerMapper.selectStuCustomerByMajorId(stuCustomer.getMajorId());
                    //根据学生查询所有的合同
                    return getStuContracts(list, sysUser, customers);
                }
                case "grade": {
                    //根据年纪id查询所有的学生
                    List<StuCustomer> customers = stuCustomerMapper.selectStuCustomerByGradeId(stuCustomer.getGradeId());
                    //根据学生查询所有的合同
                    return getStuContracts(list, sysUser, customers);
                }
                case "class": {
                    //根据班级id查询所有的学生
                    List<StuCustomer> customers = stuCustomerMapper.selectStuCustomerByClassId(stuCustomer.getClassId());
                    //根据学生查询所有的合同
                    return getStuContracts(list, sysUser, customers);
                }
                default:
                    return list;
            }
        }
    }

    private static List<StuContract> getStuContracts(List<StuContract> list, SysUser sysUser, List<StuCustomer> customers) {
        List<StuContract> res = new ArrayList<>();
        customers.forEach((student) -> {
            List<StuContract> collect = list.stream().filter((value) -> {
                return value.getStudentId().toString().equals(sysUser.getUserId().toString());
            }).collect(Collectors.toList());
            res.addAll(collect);
        });
        return res;
    }

    /**
     * 新增合同信息管理
     *
     * @param stuContract 合同信息管理
     * @param request
     * @return 结果
     */
    @Override
    public int insertStuContract(StuContract stuContract, HttpServletRequest request) {
        stuContract.setCreateTime(DateUtils.getNowDate());
        System.out.println(stuContract);
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                System.out.println(cookie.getValue());
                stuContract.setStudentName(cookie.getValue());
                SysUser stuCustomer = sysUserService.selectUserByUserName(cookie.getValue());
                stuContract.setStudentId(stuCustomer.getUserId());
                stuContract.setIsDisbursed("否");
                stuContract.setCreator(cookie.getValue());
                stuContract.setUpdater(cookie.getValue());
                stuContract.setAcademicYear(new SimpleDateFormat("yyyy").format(new Date()) + "年");
            }
        }

        StuBank bank = stuBankMapper.selectStuBankByBankName(stuContract.getBankName());
        if (bank != null) {
            stuContract.setBankId(bank.getBankId());
        }
        return stuContractMapper.insertStuContract(stuContract);
    }

    /**
     * 修改合同信息管理
     *
     * @param stuContract 合同信息管理
     * @return 结果
     */
    @Override
    public int updateStuContract(StuContract stuContract) {
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
    public int deleteStuContractByIds(Long[] ids) {
        return stuContractMapper.deleteStuContractByIds(ids);
    }

    /**
     * 删除合同信息管理信息
     *
     * @param id 合同信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuContractById(Long id) {
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
            if (cookie.getName().equals("username")) {
                username = cookie.getName();
            }
        }
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        stuContract.setStudentId(sysUser.getUserId());
        stuContract.setLoanAmount(new BigDecimal(pactVo.getMoney()));
        stuContract.setIsDisbursed("否");
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
