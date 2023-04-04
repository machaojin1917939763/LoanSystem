package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClassMapper;
import com.ruoyi.system.domain.SysClass;
import com.ruoyi.system.service.ISysClassService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysClassServiceImpl implements ISysClassService 
{
    @Autowired
    private SysClassMapper sysClassMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param classId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysClass selectSysClassByClassId(Long classId)
    {
        return sysClassMapper.selectSysClassByClassId(classId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysClass 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysClass> selectSysClassList(SysClass sysClass)
    {
        return sysClassMapper.selectSysClassList(sysClass);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysClass 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysClass(SysClass sysClass)
    {
        sysClass.setCreateTime(DateUtils.getNowDate());
        return sysClassMapper.insertSysClass(sysClass);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysClass 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysClass(SysClass sysClass)
    {
        sysClass.setUpdateTime(DateUtils.getNowDate());
        return sysClassMapper.updateSysClass(sysClass);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param classIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysClassByClassIds(Long[] classIds)
    {
        return sysClassMapper.deleteSysClassByClassIds(classIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param classId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysClassByClassId(Long classId)
    {
        return sysClassMapper.deleteSysClassByClassId(classId);
    }
}
