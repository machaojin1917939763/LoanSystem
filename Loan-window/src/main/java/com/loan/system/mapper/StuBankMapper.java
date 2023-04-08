package com.loan.system.mapper;

import java.util.List;
import com.loan.system.domain.StuBank;
import org.apache.ibatis.annotations.Mapper;

/**
 * 银行Mapper接口
 * 
 * @author loan
 * @date 2023-04-04
 */
@Mapper
public interface StuBankMapper 
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
     * 删除银行
     * 
     * @param bankId 银行主键
     * @return 结果
     */
    public int deleteStuBankByBankId(Long bankId);

    /**
     * 批量删除银行
     * 
     * @param bankIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuBankByBankIds(Long[] bankIds);
}
