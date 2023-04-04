package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StuMajor;

/**
 * 专业管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
public interface IStuMajorService 
{
    /**
     * 查询专业管理
     * 
     * @param majorId 专业管理主键
     * @return 专业管理
     */
    public StuMajor selectStuMajorByMajorId(Long majorId);

    /**
     * 查询专业管理列表
     * 
     * @param stuMajor 专业管理
     * @return 专业管理集合
     */
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor);

    /**
     * 新增专业管理
     * 
     * @param stuMajor 专业管理
     * @return 结果
     */
    public int insertStuMajor(StuMajor stuMajor);

    /**
     * 修改专业管理
     * 
     * @param stuMajor 专业管理
     * @return 结果
     */
    public int updateStuMajor(StuMajor stuMajor);

    /**
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的专业管理主键集合
     * @return 结果
     */
    public int deleteStuMajorByMajorIds(Long[] majorIds);

    /**
     * 删除专业管理信息
     * 
     * @param majorId 专业管理主键
     * @return 结果
     */
    public int deleteStuMajorByMajorId(Long majorId);
}
