package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuContractMapper;
import com.ruoyi.system.domain.StuContract;
import com.ruoyi.system.service.IStuContractService;

/**
 * 合同信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Service
public class StuContractServiceImpl implements IStuContractService 
{
    @Autowired
    private StuContractMapper stuContractMapper;

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
        return stuContractMapper.selectStuContractList(stuContract);
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
}
