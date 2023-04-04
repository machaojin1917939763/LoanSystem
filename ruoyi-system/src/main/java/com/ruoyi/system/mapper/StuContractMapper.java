package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuContract;
import org.apache.ibatis.annotations.Mapper;

/**
 * 合同信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Mapper
public interface StuContractMapper 
{
    /**
     * 查询合同信息管理
     * 
     * @param id 合同信息管理主键
     * @return 合同信息管理
     */
    public StuContract selectStuContractById(Long id);

    /**
     * 查询合同信息管理列表
     * 
     * @param stuContract 合同信息管理
     * @return 合同信息管理集合
     */
    public List<StuContract> selectStuContractList(StuContract stuContract);

    /**
     * 新增合同信息管理
     * 
     * @param stuContract 合同信息管理
     * @return 结果
     */
    public int insertStuContract(StuContract stuContract);

    /**
     * 修改合同信息管理
     * 
     * @param stuContract 合同信息管理
     * @return 结果
     */
    public int updateStuContract(StuContract stuContract);

    /**
     * 删除合同信息管理
     * 
     * @param id 合同信息管理主键
     * @return 结果
     */
    public int deleteStuContractById(Long id);

    /**
     * 批量删除合同信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuContractByIds(Long[] ids);
}
