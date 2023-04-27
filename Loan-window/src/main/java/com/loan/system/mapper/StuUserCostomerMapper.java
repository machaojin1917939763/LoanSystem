package com.loan.system.mapper;

import java.util.List;
import com.loan.system.domain.StuUserCostomer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author loan
 * @date 2023-04-27
 */
@Mapper
public interface StuUserCostomerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public StuUserCostomer selectStuUserCostomerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<StuUserCostomer> selectStuUserCostomerList(StuUserCostomer stuUserCostomer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 结果
     */
    public int insertStuUserCostomer(StuUserCostomer stuUserCostomer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 结果
     */
    public int updateStuUserCostomer(StuUserCostomer stuUserCostomer);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteStuUserCostomerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuUserCostomerByIds(Long[] ids);
}
