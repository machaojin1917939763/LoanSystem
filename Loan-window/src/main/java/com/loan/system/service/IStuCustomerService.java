package com.loan.system.service;

import java.util.List;
import com.loan.system.domain.StuCustomer;

/**
 * 客户信息管理Service接口
 * 
 * @author loan
 * @date 2023-04-04
 */
public interface IStuCustomerService 
{
    /**
     * 查询客户信息管理
     * 
     * @param customerId 客户信息管理主键
     * @return 客户信息管理
     */
    public StuCustomer selectStuCustomerByCustomerId(Long customerId);

    /**
     * 查询客户信息管理列表
     * 
     * @param stuCustomer 客户信息管理
     * @return 客户信息管理集合
     */
    public List<StuCustomer> selectStuCustomerList(StuCustomer stuCustomer);

    /**
     * 新增客户信息管理
     * 
     * @param stuCustomer 客户信息管理
     * @return 结果
     */
    public int insertStuCustomer(StuCustomer stuCustomer);

    /**
     * 修改客户信息管理
     * 
     * @param stuCustomer 客户信息管理
     * @return 结果
     */
    public int updateStuCustomer(StuCustomer stuCustomer);

    /**
     * 批量删除客户信息管理
     * 
     * @param customerIds 需要删除的客户信息管理主键集合
     * @return 结果
     */
    public int deleteStuCustomerByCustomerIds(Long[] customerIds);

    /**
     * 删除客户信息管理信息
     * 
     * @param customerId 客户信息管理主键
     * @return 结果
     */
    public int deleteStuCustomerByCustomerId(Long customerId);

    StuCustomer selectStuCustomerOnThis(String username);
}
