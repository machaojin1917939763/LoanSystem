package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import com.loan.system.domain.StuGrade;
import com.loan.system.mapper.StuGradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuClassMapper;
import com.loan.system.domain.StuClass;
import com.loan.system.service.IStuClassService;

/**
 * 班级管理Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuClassServiceImpl implements IStuClassService 
{
    @Autowired
    private StuClassMapper stuClassMapper;
    @Autowired
    private StuGradeMapper stuGradeMapper;

    /**
     * 查询班级管理
     * 
     * @param classId 班级管理主键
     * @return 班级管理
     */
    @Override
    public StuClass selectStuClassByClassId(Long classId)
    {
        return stuClassMapper.selectStuClassByClassId(classId);
    }

    /**
     * 查询班级管理列表
     * 
     * @param stuClass 班级管理
     * @return 班级管理
     */
    @Override
    public List<StuClass> selectStuClassList(StuClass stuClass)
    {
        List<StuClass> stuClasses = stuClassMapper.selectStuClassList(stuClass);
        for (StuClass aClass : stuClasses) {
            String gradeId = aClass.getGradeId();
            StuGrade stuGrade = stuGradeMapper.selectStuGradeByGradeId(Long.parseLong(gradeId));
            if (stuGrade!=null){
                aClass.setGradeId(stuGrade.getName());
            }else {
                return null;
            }

        }
        return stuClasses;
    }

    /**
     * 新增班级管理
     * 
     * @param stuClass 班级管理
     * @return 结果
     */
    @Override
    public int insertStuClass(StuClass stuClass)
    {
        stuClass.setCreateTime(DateUtils.getNowDate());
        return stuClassMapper.insertStuClass(stuClass);
    }

    /**
     * 修改班级管理
     * 
     * @param stuClass 班级管理
     * @return 结果
     */
    @Override
    public int updateStuClass(StuClass stuClass)
    {
        stuClass.setUpdateTime(DateUtils.getNowDate());
        return stuClassMapper.updateStuClass(stuClass);
    }

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByClassIds(Long[] classIds)
    {
        return stuClassMapper.deleteStuClassByClassIds(classIds);
    }

    /**
     * 删除班级管理信息
     * 
     * @param classId 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteStuClassByClassId(Long classId)
    {
        return stuClassMapper.deleteStuClassByClassId(classId);
    }
}
