package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuCollegeMapper;
import com.loan.system.domain.StuCollege;
import com.loan.system.service.IStuCollegeService;

/**
 * 学院管理Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuCollegeServiceImpl implements IStuCollegeService 
{
    @Autowired
    private StuCollegeMapper stuCollegeMapper;

    /**
     * 查询学院管理
     * 
     * @param collegeId 学院管理主键
     * @return 学院管理
     */
    @Override
    public StuCollege selectStuCollegeByCollegeId(Long collegeId)
    {
        return stuCollegeMapper.selectStuCollegeByCollegeId(collegeId);
    }

    /**
     * 查询学院管理列表
     * 
     * @param stuCollege 学院管理
     * @return 学院管理
     */
    @Override
    public List<StuCollege> selectStuCollegeList(StuCollege stuCollege)
    {
        return stuCollegeMapper.selectStuCollegeList(stuCollege);
    }

    /**
     * 新增学院管理
     * 
     * @param stuCollege 学院管理
     * @return 结果
     */
    @Override
    public int insertStuCollege(StuCollege stuCollege)
    {
        stuCollege.setCreateTime(DateUtils.getNowDate());
        return stuCollegeMapper.insertStuCollege(stuCollege);
    }

    /**
     * 修改学院管理
     * 
     * @param stuCollege 学院管理
     * @return 结果
     */
    @Override
    public int updateStuCollege(StuCollege stuCollege)
    {
        stuCollege.setUpdateTime(DateUtils.getNowDate());
        return stuCollegeMapper.updateStuCollege(stuCollege);
    }

    /**
     * 批量删除学院管理
     * 
     * @param collegeIds 需要删除的学院管理主键
     * @return 结果
     */
    @Override
    public int deleteStuCollegeByCollegeIds(Long[] collegeIds)
    {
        return stuCollegeMapper.deleteStuCollegeByCollegeIds(collegeIds);
    }

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院管理主键
     * @return 结果
     */
    @Override
    public int deleteStuCollegeByCollegeId(Long collegeId)
    {
        return stuCollegeMapper.deleteStuCollegeByCollegeId(collegeId);
    }
}
