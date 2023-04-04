package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StuBankMapper;
import com.ruoyi.system.domain.StuBank;
import com.ruoyi.system.service.IStuBankService;

/**
 * 银行Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Service
public class StuBankServiceImpl implements IStuBankService 
{
    @Autowired
    private StuBankMapper stuBankMapper;

    /**
     * 查询银行
     * 
     * @param bankId 银行主键
     * @return 银行
     */
    @Override
    public StuBank selectStuBankByBankId(Long bankId)
    {
        return stuBankMapper.selectStuBankByBankId(bankId);
    }

    /**
     * 查询银行列表
     * 
     * @param stuBank 银行
     * @return 银行
     */
    @Override
    public List<StuBank> selectStuBankList(StuBank stuBank)
    {
        return stuBankMapper.selectStuBankList(stuBank);
    }

    /**
     * 新增银行
     * 
     * @param stuBank 银行
     * @return 结果
     */
    @Override
    public int insertStuBank(StuBank stuBank)
    {
        stuBank.setCreateTime(DateUtils.getNowDate());
        return stuBankMapper.insertStuBank(stuBank);
    }

    /**
     * 修改银行
     * 
     * @param stuBank 银行
     * @return 结果
     */
    @Override
    public int updateStuBank(StuBank stuBank)
    {
        stuBank.setUpdateTime(DateUtils.getNowDate());
        return stuBankMapper.updateStuBank(stuBank);
    }

    /**
     * 批量删除银行
     * 
     * @param bankIds 需要删除的银行主键
     * @return 结果
     */
    @Override
    public int deleteStuBankByBankIds(Long[] bankIds)
    {
        return stuBankMapper.deleteStuBankByBankIds(bankIds);
    }

    /**
     * 删除银行信息
     * 
     * @param bankId 银行主键
     * @return 结果
     */
    @Override
    public int deleteStuBankByBankId(Long bankId)
    {
        return stuBankMapper.deleteStuBankByBankId(bankId);
    }
}
