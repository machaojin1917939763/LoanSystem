package com.loan.system.service.impl;

import java.util.List;

import com.loan.common.utils.DateUtils;
import com.loan.system.domain.*;
import com.loan.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.service.IStuCustomerService;

/**
 * 客户信息管理Service业务层处理
 *
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuCustomerServiceImpl implements IStuCustomerService {
    @Autowired
    private StuCustomerMapper stuCustomerMapper;

    @Autowired
    private StuCollegeMapper stuCollegeMapper;

    @Autowired
    private StuClassMapper stuClassMapper;

    @Autowired
    private StuGradeMapper stuGradeMapper;

    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询客户信息管理
     *
     * @param customerId 客户信息管理主键
     * @return 客户信息管理
     */
    @Override
    public StuCustomer selectStuCustomerByCustomerId(Long customerId) {
        return stuCustomerMapper.selectStuCustomerByCustomerId(customerId);
    }

    /**
     * 查询客户信息管理列表
     *
     * @param stuCustomer 客户信息管理
     * @return 客户信息管理
     */
    @Override
    public List<StuCustomer> selectStuCustomerList(StuCustomer stuCustomer) {
        List<StuCustomer> stuCustomers = stuCustomerMapper.selectStuCustomerList(stuCustomer);
        if (stuCustomers != null && stuCustomers.size() > 0) {
            stuCustomers.forEach((student) -> {
                //查询学院
                if (student.getCollegeId() != null) {
                    StuCollege stuCollege = stuCollegeMapper.selectStuCollegeByCollegeId(Long.parseLong(student.getCollegeId()));
                    student.setCollegeId(stuCollege != null ? stuCollege.getName() : student.getCollegeId());
                }
                //查询班级
                if (student.getClassId() != null) {
                    StuClass stuClass = stuClassMapper.selectStuClassByClassId(Long.parseLong(student.getClassId()));
                    System.out.println(stuClass);
                    student.setClassId(stuClass != null ? stuClass.getName() : student.getClassId());
                }
                //查询专业
                if (student.getMajorId() != null) {
                    StuMajor stuMajor = stuMajorMapper.selectStuMajorByMajorId(Long.parseLong(student.getMajorId()));
                    student.setMajorId(stuMajor != null ? stuMajor.getName() : student.getMajorId());
                }
                //查询年级
                if (student.getGradeId() != null) {
                    StuGrade stuGrade = stuGradeMapper.selectStuGradeByGradeId(Long.parseLong(student.getGradeId()));
                    student.setGradeId(stuGrade != null ? stuGrade.getName() : student.getGradeId());
                }
            });

        }
        return stuCustomers;
    }

    /**
     * 新增客户信息管理
     *
     * @param stuCustomer 客户信息管理
     * @return 结果
     */
    @Override
    public int insertStuCustomer(StuCustomer stuCustomer) {
        stuCustomer.setCreateTime(DateUtils.getNowDate());
        return stuCustomerMapper.insertStuCustomer(stuCustomer);
    }

    /**
     * 修改客户信息管理
     *
     * @param stuCustomer 客户信息管理
     * @return 结果
     */
    @Override
    public int updateStuCustomer(StuCustomer stuCustomer) {
        stuCustomer.setUpdateTime(DateUtils.getNowDate());
        return stuCustomerMapper.updateStuCustomer(stuCustomer);
    }

    /**
     * 批量删除客户信息管理
     *
     * @param customerIds 需要删除的客户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuCustomerByCustomerIds(Long[] customerIds) {
        return stuCustomerMapper.deleteStuCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除客户信息管理信息
     *
     * @param customerId 客户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteStuCustomerByCustomerId(Long customerId) {
        return stuCustomerMapper.deleteStuCustomerByCustomerId(customerId);
    }

    @Override
    public StuCustomer selectStuCustomerOnThis(String username) {
        return stuCustomerMapper.selectStuCustomerOnThis(username);
    }
}
