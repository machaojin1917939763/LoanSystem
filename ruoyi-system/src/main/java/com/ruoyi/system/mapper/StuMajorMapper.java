package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuMajor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 专业管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Mapper
public interface StuMajorMapper 
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
     * 删除专业管理
     * 
     * @param majorId 专业管理主键
     * @return 结果
     */
    public int deleteStuMajorByMajorId(Long majorId);

    /**
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuMajorByMajorIds(Long[] majorIds);
}
