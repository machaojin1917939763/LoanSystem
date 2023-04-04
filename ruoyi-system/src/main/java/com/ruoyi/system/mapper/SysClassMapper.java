package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysClass;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface SysClassMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param classId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysClass selectSysClassByClassId(Long classId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysClass 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysClass> selectSysClassList(SysClass sysClass);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysClass 【请填写功能名称】
     * @return 结果
     */
    public int insertSysClass(SysClass sysClass);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysClass 【请填写功能名称】
     * @return 结果
     */
    public int updateSysClass(SysClass sysClass);

    /**
     * 删除【请填写功能名称】
     * 
     * @param classId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysClassByClassId(Long classId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param classIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysClassByClassIds(Long[] classIds);
}
