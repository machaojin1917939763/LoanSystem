package com.loan.system.service;

import java.util.List;
import com.loan.system.domain.StuCollege;

/**
 * 学院管理Service接口
 * 
 * @author loan
 * @date 2023-04-04
 */
public interface IStuCollegeService 
{
    /**
     * 查询学院管理
     * 
     * @param collegeId 学院管理主键
     * @return 学院管理
     */
    public StuCollege selectStuCollegeByCollegeId(Long collegeId);

    /**
     * 查询学院管理列表
     * 
     * @param stuCollege 学院管理
     * @return 学院管理集合
     */
    public List<StuCollege> selectStuCollegeList(StuCollege stuCollege);

    /**
     * 新增学院管理
     * 
     * @param stuCollege 学院管理
     * @return 结果
     */
    public int insertStuCollege(StuCollege stuCollege);

    /**
     * 修改学院管理
     * 
     * @param stuCollege 学院管理
     * @return 结果
     */
    public int updateStuCollege(StuCollege stuCollege);

    /**
     * 批量删除学院管理
     * 
     * @param collegeIds 需要删除的学院管理主键集合
     * @return 结果
     */
    public int deleteStuCollegeByCollegeIds(Long[] collegeIds);

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院管理主键
     * @return 结果
     */
    public int deleteStuCollegeByCollegeId(Long collegeId);
}
