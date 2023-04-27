package com.loan.system.service;

import java.util.List;
import com.loan.system.domain.StuUserCostomer;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author loan
 * @date 2023-04-27
 */
public interface IStuUserCostomerService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteStuUserCostomerByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteStuUserCostomerById(Long id);
}
