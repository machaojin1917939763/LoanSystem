package com.loan.system.mapper;

import java.util.List;
import com.loan.system.domain.StuCollege;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学院管理Mapper接口
 * 
 * @author loan
 * @date 2023-04-04
 */
@Mapper
public interface StuCollegeMapper 
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
     * 删除学院管理
     * 
     * @param collegeId 学院管理主键
     * @return 结果
     */
    public int deleteStuCollegeByCollegeId(Long collegeId);

    /**
     * 批量删除学院管理
     * 
     * @param collegeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuCollegeByCollegeIds(Long[] collegeIds);

    StuCollege selectStuCollegeByCollegeName(String collegeId);
}
