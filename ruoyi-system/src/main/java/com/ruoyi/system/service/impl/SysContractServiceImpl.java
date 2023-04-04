package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysContractMapper;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.service.ISysContractService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysContractServiceImpl implements ISysContractService 
{
    @Autowired
    private SysContractMapper sysContractMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysContract selectSysContractById(Long id)
    {
        return sysContractMapper.selectSysContractById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysContract 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysContract> selectSysContractList(SysContract sysContract)
    {
        return sysContractMapper.selectSysContractList(sysContract);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysContract 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysContract(SysContract sysContract)
    {
        sysContract.setCreateTime(DateUtils.getNowDate());
        return sysContractMapper.insertSysContract(sysContract);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysContract 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysContract(SysContract sysContract)
    {
        sysContract.setUpdateTime(DateUtils.getNowDate());
        return sysContractMapper.updateSysContract(sysContract);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysContractByIds(Long[] ids)
    {
        return sysContractMapper.deleteSysContractByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysContractById(Long id)
    {
        return sysContractMapper.deleteSysContractById(id);
    }
}
