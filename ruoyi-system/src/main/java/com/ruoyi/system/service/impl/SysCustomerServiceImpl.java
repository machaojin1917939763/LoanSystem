package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCustomerMapper;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysCustomerServiceImpl implements ISysCustomerService 
{
    @Autowired
    private SysCustomerMapper sysCustomerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysCustomer selectSysCustomerByCustomerId(Long customerId)
    {
        return sysCustomerMapper.selectSysCustomerByCustomerId(customerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer)
    {
        return sysCustomerMapper.selectSysCustomerList(sysCustomer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysCustomer(SysCustomer sysCustomer)
    {
        sysCustomer.setCreateTime(DateUtils.getNowDate());
        return sysCustomerMapper.insertSysCustomer(sysCustomer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysCustomer(SysCustomer sysCustomer)
    {
        sysCustomer.setUpdateTime(DateUtils.getNowDate());
        return sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerByCustomerIds(Long[] customerIds)
    {
        return sysCustomerMapper.deleteSysCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerByCustomerId(Long customerId)
    {
        return sysCustomerMapper.deleteSysCustomerByCustomerId(customerId);
    }
}
