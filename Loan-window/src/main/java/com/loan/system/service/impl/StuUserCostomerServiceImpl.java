package com.loan.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuUserCostomerMapper;
import com.loan.system.domain.StuUserCostomer;
import com.loan.system.service.IStuUserCostomerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author loan
 * @date 2023-04-27
 */
@Service
public class StuUserCostomerServiceImpl implements IStuUserCostomerService 
{
    @Autowired
    private StuUserCostomerMapper stuUserCostomerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public StuUserCostomer selectStuUserCostomerById(Long id)
    {
        return stuUserCostomerMapper.selectStuUserCostomerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<StuUserCostomer> selectStuUserCostomerList(StuUserCostomer stuUserCostomer)
    {
        return stuUserCostomerMapper.selectStuUserCostomerList(stuUserCostomer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertStuUserCostomer(StuUserCostomer stuUserCostomer)
    {
        return stuUserCostomerMapper.insertStuUserCostomer(stuUserCostomer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param stuUserCostomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateStuUserCostomer(StuUserCostomer stuUserCostomer)
    {
        return stuUserCostomerMapper.updateStuUserCostomer(stuUserCostomer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStuUserCostomerByIds(Long[] ids)
    {
        return stuUserCostomerMapper.deleteStuUserCostomerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStuUserCostomerById(Long id)
    {
        return stuUserCostomerMapper.deleteStuUserCostomerById(id);
    }
}
