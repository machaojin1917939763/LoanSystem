package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StuLoanDisbursementTime;
import org.apache.ibatis.annotations.Mapper;

/**
 * 放款时间Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Mapper
public interface StuLoanDisbursementTimeMapper 
{
    /**
     * 查询放款时间
     * 
     * @param timeId 放款时间主键
     * @return 放款时间
     */
    public StuLoanDisbursementTime selectStuLoanDisbursementTimeByTimeId(Long timeId);

    /**
     * 查询放款时间列表
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 放款时间集合
     */
    public List<StuLoanDisbursementTime> selectStuLoanDisbursementTimeList(StuLoanDisbursementTime stuLoanDisbursementTime);

    /**
     * 新增放款时间
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 结果
     */
    public int insertStuLoanDisbursementTime(StuLoanDisbursementTime stuLoanDisbursementTime);

    /**
     * 修改放款时间
     * 
     * @param stuLoanDisbursementTime 放款时间
     * @return 结果
     */
    public int updateStuLoanDisbursementTime(StuLoanDisbursementTime stuLoanDisbursementTime);

    /**
     * 删除放款时间
     * 
     * @param timeId 放款时间主键
     * @return 结果
     */
    public int deleteStuLoanDisbursementTimeByTimeId(Long timeId);

    /**
     * 批量删除放款时间
     * 
     * @param timeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuLoanDisbursementTimeByTimeIds(Long[] timeIds);
}
