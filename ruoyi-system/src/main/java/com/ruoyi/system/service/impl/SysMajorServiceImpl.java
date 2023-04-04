package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMajorMapper;
import com.ruoyi.system.domain.SysMajor;
import com.ruoyi.system.service.ISysMajorService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysMajorServiceImpl implements ISysMajorService 
{
    @Autowired
    private SysMajorMapper sysMajorMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param majorId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysMajor selectSysMajorByMajorId(Long majorId)
    {
        return sysMajorMapper.selectSysMajorByMajorId(majorId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysMajor> selectSysMajorList(SysMajor sysMajor)
    {
        return sysMajorMapper.selectSysMajorList(sysMajor);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysMajor(SysMajor sysMajor)
    {
        sysMajor.setCreateTime(DateUtils.getNowDate());
        return sysMajorMapper.insertSysMajor(sysMajor);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysMajor(SysMajor sysMajor)
    {
        sysMajor.setUpdateTime(DateUtils.getNowDate());
        return sysMajorMapper.updateSysMajor(sysMajor);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param majorIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMajorByMajorIds(Long[] majorIds)
    {
        return sysMajorMapper.deleteSysMajorByMajorIds(majorIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param majorId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMajorByMajorId(Long majorId)
    {
        return sysMajorMapper.deleteSysMajorByMajorId(majorId);
    }
}
