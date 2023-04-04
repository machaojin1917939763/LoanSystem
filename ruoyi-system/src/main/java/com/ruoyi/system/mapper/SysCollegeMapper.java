package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCollege;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface SysCollegeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param collegeId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysCollege selectSysCollegeByCollegeId(Long collegeId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysCollege> selectSysCollegeList(SysCollege sysCollege);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 结果
     */
    public int insertSysCollege(SysCollege sysCollege);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCollege 【请填写功能名称】
     * @return 结果
     */
    public int updateSysCollege(SysCollege sysCollege);

    /**
     * 删除【请填写功能名称】
     * 
     * @param collegeId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysCollegeByCollegeId(Long collegeId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param collegeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCollegeByCollegeIds(Long[] collegeIds);
}
