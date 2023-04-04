package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuClass;
import org.apache.ibatis.annotations.Mapper;

/**
 * 班级管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Mapper
public interface StuClassMapper 
{
    /**
     * 查询班级管理
     * 
     * @param classId 班级管理主键
     * @return 班级管理
     */
    public StuClass selectStuClassByClassId(Long classId);

    /**
     * 查询班级管理列表
     * 
     * @param stuClass 班级管理
     * @return 班级管理集合
     */
    public List<StuClass> selectStuClassList(StuClass stuClass);

    /**
     * 新增班级管理
     * 
     * @param stuClass 班级管理
     * @return 结果
     */
    public int insertStuClass(StuClass stuClass);

    /**
     * 修改班级管理
     * 
     * @param stuClass 班级管理
     * @return 结果
     */
    public int updateStuClass(StuClass stuClass);

    /**
     * 删除班级管理
     * 
     * @param classId 班级管理主键
     * @return 结果
     */
    public int deleteStuClassByClassId(Long classId);

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuClassByClassIds(Long[] classIds);
}
