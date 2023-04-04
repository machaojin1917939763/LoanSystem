package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGradeMapper;
import com.ruoyi.system.domain.SysGrade;
import com.ruoyi.system.service.ISysGradeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysGradeServiceImpl implements ISysGradeService 
{
    @Autowired
    private SysGradeMapper sysGradeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param gradeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysGrade selectSysGradeByGradeId(Long gradeId)
    {
        return sysGradeMapper.selectSysGradeByGradeId(gradeId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysGrade> selectSysGradeList(SysGrade sysGrade)
    {
        return sysGradeMapper.selectSysGradeList(sysGrade);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysGrade(SysGrade sysGrade)
    {
        sysGrade.setCreateTime(DateUtils.getNowDate());
        return sysGradeMapper.insertSysGrade(sysGrade);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysGrade(SysGrade sysGrade)
    {
        sysGrade.setUpdateTime(DateUtils.getNowDate());
        return sysGradeMapper.updateSysGrade(sysGrade);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param gradeIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysGradeByGradeIds(Long[] gradeIds)
    {
        return sysGradeMapper.deleteSysGradeByGradeIds(gradeIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param gradeId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysGradeByGradeId(Long gradeId)
    {
        return sysGradeMapper.deleteSysGradeByGradeId(gradeId);
    }
}
