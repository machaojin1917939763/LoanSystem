package com.loan.system.service;

import java.util.List;
import com.loan.system.domain.StuGrade;

/**
 * 年级管理Service接口
 * 
 * @author loan
 * @date 2023-04-04
 */
public interface IStuGradeService 
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
     * 批量删除年级管理
     * 
     * @param gradeIds 需要删除的年级管理主键集合
     * @return 结果
     */
    public int deleteStuGradeByGradeIds(Long[] gradeIds);

    /**
     * 删除年级管理信息
     * 
     * @param gradeId 年级管理主键
     * @return 结果
     */
    public int deleteStuGradeByGradeId(Long gradeId);
}
