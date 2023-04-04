package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysMajor;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-03
 */
public interface SysMajorMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param majorId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysMajor selectSysMajorByMajorId(Long majorId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysMajor> selectSysMajorList(SysMajor sysMajor);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 结果
     */
    public int insertSysMajor(SysMajor sysMajor);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysMajor 【请填写功能名称】
     * @return 结果
     */
    public int updateSysMajor(SysMajor sysMajor);

    /**
     * 删除【请填写功能名称】
     * 
     * @param majorId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysMajorByMajorId(Long majorId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param majorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMajorByMajorIds(Long[] majorIds);
}
