package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import com.loan.system.domain.StuMajor;
import com.loan.system.mapper.StuMajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuGradeMapper;
import com.loan.system.domain.StuGrade;
import com.loan.system.service.IStuGradeService;

/**
 * 年级管理Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuGradeServiceImpl implements IStuGradeService 
{
    @Autowired
    private StuGradeMapper stuGradeMapper;
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询年级管理
     * 
     * @param gradeId 年级管理主键
     * @return 年级管理
     */
    @Override
    public StuGrade selectStuGradeByGradeId(Long gradeId)
    {
        return stuGradeMapper.selectStuGradeByGradeId(gradeId);
    }

    /**
     * 查询年级管理列表
     * 
     * @param stuGrade 年级管理
     * @return 年级管理
     */
    @Override
    public List<StuGrade> selectStuGradeList(StuGrade stuGrade)
    {
        List<StuGrade> stuGrades = stuGradeMapper.selectStuGradeList(stuGrade);
        for (StuGrade grade : stuGrades) {
            String majorId = grade.getMajorId();
            StuMajor stuMajor = stuMajorMapper.selectStuMajorByMajorId(Long.parseLong(majorId));
            if (stuMajor!=null){
                grade.setMajorId(stuMajor.getName());
            }else {
                return null;
            }

        }
        return stuGrades;
    }

    /**
     * 新增年级管理
     * 
     * @param stuGrade 年级管理
     * @return 结果
     */
    @Override
    public int insertStuGrade(StuGrade stuGrade)
    {
        stuGrade.setCreateTime(DateUtils.getNowDate());
        return stuGradeMapper.insertStuGrade(stuGrade);
    }

    /**
     * 修改年级管理
     * 
     * @param stuGrade 年级管理
     * @return 结果
     */
    @Override
    public int updateStuGrade(StuGrade stuGrade)
    {
        stuGrade.setUpdateTime(DateUtils.getNowDate());
        return stuGradeMapper.updateStuGrade(stuGrade);
    }

    /**
     * 批量删除年级管理
     * 
     * @param gradeIds 需要删除的年级管理主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeByGradeIds(Long[] gradeIds)
    {
        return stuGradeMapper.deleteStuGradeByGradeIds(gradeIds);
    }

    /**
     * 删除年级管理信息
     * 
     * @param gradeId 年级管理主键
     * @return 结果
     */
    @Override
    public int deleteStuGradeByGradeId(Long gradeId)
    {
        return stuGradeMapper.deleteStuGradeByGradeId(gradeId);
    }
}
