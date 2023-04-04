package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGrade;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface SysGradeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param gradeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysGrade selectSysGradeByGradeId(Long gradeId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysGrade> selectSysGradeList(SysGrade sysGrade);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 结果
     */
    public int insertSysGrade(SysGrade sysGrade);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysGrade 【请填写功能名称】
     * @return 结果
     */
    public int updateSysGrade(SysGrade sysGrade);

    /**
     * 删除【请填写功能名称】
     * 
     * @param gradeId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysGradeByGradeId(Long gradeId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param gradeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysGradeByGradeIds(Long[] gradeIds);
}
