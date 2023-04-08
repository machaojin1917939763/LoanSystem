package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuLoanDisbursementTimeMapper;
import com.loan.system.domain.StuLoanDisbursementTime;
import com.loan.system.service.IStuLoanDisbursementTimeService;

/**
 * 放款时间Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuLoanDisbursementTimeServiceImpl implements IStuLoanDisbursementTimeService 
{
    @Autowired
    private StuLoanDisbursementTimeMapper stuLoanDisbursementTimeMapper;

    /**
     * 查询放款时间
     * 
     * @param timeId 放款时间主键
     * @return 放款时间
     */
    @Override
    public StuLoanDisbursementTime selectStuLoanDisbursementTimeByTimeId(Long timeId)
    {
        return stuLoanDisbursementTimeMapper.selectStuLoanDisbursementTimeByTimeId(timeId);
    }

    /**
     * 查询放款时间列表
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 放款时间
     */
    @Override
    public List<StuLoanDisbursementTime> selectStuLoanDisbursementTimeList(StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        return stuLoanDisbursementTimeMapper.selectStuLoanDisbursementTimeList(stuLoanDisbursementTime);
    }

    /**
     * 新增放款时间
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 结果
     */
    @Override
    public int insertStuLoanDisbursementTime(StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        stuLoanDisbursementTime.setCreateTime(DateUtils.getNowDate());
        return stuLoanDisbursementTimeMapper.insertStuLoanDisbursementTime(stuLoanDisbursementTime);
    }

    /**
     * 修改放款时间
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 结果
     */
    @Override
    public int updateStuLoanDisbursementTime(StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        stuLoanDisbursementTime.setUpdateTime(DateUtils.getNowDate());
        return stuLoanDisbursementTimeMapper.updateStuLoanDisbursementTime(stuLoanDisbursementTime);
    }

    /**
     * 批量删除放款时间
     * 
     * @param timeIds 需要删除的放款时间主键
     * @return 结果
     */
    @Override
    public int deleteStuLoanDisbursementTimeByTimeIds(Long[] timeIds)
    {
        return stuLoanDisbursementTimeMapper.deleteStuLoanDisbursementTimeByTimeIds(timeIds);
    }

    /**
     * 删除放款时间信息
     * 
     * @param timeId 放款时间主键
     * @return 结果
     */
    @Override
    public int deleteStuLoanDisbursementTimeByTimeId(Long timeId)
    {
        return stuLoanDisbursementTimeMapper.deleteStuLoanDisbursementTimeByTimeId(timeId);
    }
}
