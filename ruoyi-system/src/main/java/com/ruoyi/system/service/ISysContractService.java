package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysContract;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface ISysContractService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysContract selectSysContractById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysContract 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysContract> selectSysContractList(SysContract sysContract);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysContract 【请填写功能名称】
     * @return 结果
     */
    public int insertSysContract(SysContract sysContract);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysContract 【请填写功能名称】
     * @return 结果
     */
    public int updateSysContract(SysContract sysContract);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysContractByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysContractById(Long id);
}
