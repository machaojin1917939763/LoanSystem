package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCollegeMapper;
import com.ruoyi.system.domain.SysCollege;
import com.ruoyi.system.service.ISysCollegeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
@Service
public class SysCollegeServiceImpl implements ISysCollegeService 
{
    @Autowired
    private SysCollegeMapper sysCollegeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param collegeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysCollege selectSysCollegeByCollegeId(Long collegeId)
    {
        return sysCollegeMapper.selectSysCollegeByCollegeId(collegeId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysCollege> selectSysCollegeList(SysCollege sysCollege)
    {
        return sysCollegeMapper.selectSysCollegeList(sysCollege);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysCollege(SysCollege sysCollege)
    {
        sysCollege.setCreateTime(DateUtils.getNowDate());
        return sysCollegeMapper.insertSysCollege(sysCollege);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysCollege(SysCollege sysCollege)
    {
        sysCollege.setUpdateTime(DateUtils.getNowDate());
        return sysCollegeMapper.updateSysCollege(sysCollege);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param collegeIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCollegeByCollegeIds(Long[] collegeIds)
    {
        return sysCollegeMapper.deleteSysCollegeByCollegeIds(collegeIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param collegeId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCollegeByCollegeId(Long collegeId)
    {
        return sysCollegeMapper.deleteSysCollegeByCollegeId(collegeId);
    }
}
