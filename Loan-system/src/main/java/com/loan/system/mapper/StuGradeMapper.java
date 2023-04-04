package com.loan.system.mapper;

import java.util.List;
import com.loan.system.domain.StuGrade;
import org.apache.ibatis.annotations.Mapper;

/**
 * 年级管理Mapper接口
 * 
 * @author loan
 * @date 2023-04-04
 */
@Mapper
public interface StuGradeMapper 
{
    /**
     * 查询年级管理
     * 
     * @param gradeId 年级管理主键
     * @return 年级管理
     */
    public StuGrade selectStuGradeByGradeId(Long gradeId);

    /**
     * 查询年级管理列表
     * 
     * @param stuGrade 年级管理
     * @return 年级管理集合
     */
    public List<StuGrade> selectStuGradeList(StuGrade stuGrade);

    /**
     * 新增年级管理
     * 
     * @param stuGrade 年级管理
     * @return 结果
     */
    public int insertStuGrade(StuGrade stuGrade);

    /**
     * 修改年级管理
     * 
     * @param stuGrade 年级管理
     * @return 结果
     */
    public int updateStuGrade(StuGrade stuGrade);

    /**
     * 删除年级管理
     * 
     * @param gradeId 年级管理主键
     * @return 结果
     */
    public int deleteStuGradeByGradeId(Long gradeId);

    /**
     * 批量删除年级管理
     * 
     * @param gradeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuGradeByGradeIds(Long[] gradeIds);
}
