package com.loan.system.service;

import java.util.List;
import com.loan.system.domain.StuBank;

/**
 * 银行Service接口
 * 
 * @author loan
 * @date 2023-04-04
 */
public interface IStuBankService 
{
    /**
     * 查询银行
     * 
     * @param bankId 银行主键
     * @return 银行
     */
    public StuBank selectStuBankByBankId(Long bankId);

    /**
     * 查询银行列表
     * 
     * @param stuBank 银行
     * @return 银行集合
     */
    public List<StuBank> selectStuBankList(StuBank stuBank);

    /**
     * 新增银行
     * 
     * @param stuBank 银行
     * @return 结果
     */
    public int insertStuBank(StuBank stuBank);

    /**
     * 修改银行
     * 
     * @param stuBank 银行
     * @return 结果
     */
    public int updateStuBank(StuBank stuBank);

    /**
     * 批量删除银行
     * 
     * @param bankIds 需要删除的银行主键集合
     * @return 结果
     */
    public int deleteStuBankByBankIds(Long[] bankIds);

    /**
     * 删除银行信息
     * 
     * @param bankId 银行主键
     * @return 结果
     */
    public int deleteStuBankByBankId(Long bankId);
}
