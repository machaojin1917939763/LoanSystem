package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCustomer;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface SysCustomerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysCustomer selectSysCustomerByCustomerId(Long customerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    public int insertSysCustomer(SysCustomer sysCustomer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    public int updateSysCustomer(SysCustomer sysCustomer);

    /**
     * 删除【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysCustomerByCustomerId(Long customerId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCustomerByCustomerIds(Long[] customerIds);
}
