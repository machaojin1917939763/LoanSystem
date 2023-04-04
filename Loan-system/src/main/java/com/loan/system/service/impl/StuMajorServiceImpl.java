package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuMajorMapper;
import com.loan.system.domain.StuMajor;
import com.loan.system.service.IStuMajorService;

/**
 * 专业管理Service业务层处理
 * 
 * @author loan
 * @date 2023-04-04
 */
@Service
public class StuMajorServiceImpl implements IStuMajorService 
{
    @Autowired
    private StuMajorMapper stuMajorMapper;

    /**
     * 查询专业管理
     * 
     * @param majorId 专业管理主键
     * @return 专业管理
     */
    @Override
    public StuMajor selectStuMajorByMajorId(Long majorId)
    {
        return stuMajorMapper.selectStuMajorByMajorId(majorId);
    }

    /**
     * 查询专业管理列表
     * 
     * @param stuMajor 专业管理
     * @return 专业管理
     */
    @Override
    public List<StuMajor> selectStuMajorList(StuMajor stuMajor)
    {
        return stuMajorMapper.selectStuMajorList(stuMajor);
    }

    /**
     * 新增专业管理
     * 
     * @param stuMajor 专业管理
     * @return 结果
     */
    @Override
    public int insertStuMajor(StuMajor stuMajor)
    {
        stuMajor.setCreateTime(DateUtils.getNowDate());
        return stuMajorMapper.insertStuMajor(stuMajor);
    }

    /**
     * 修改专业管理
     * 
     * @param stuMajor 专业管理
     * @return 结果
     */
    @Override
    public int updateStuMajor(StuMajor stuMajor)
    {
        stuMajor.setUpdateTime(DateUtils.getNowDate());
        return stuMajorMapper.updateStuMajor(stuMajor);
    }

    /**
     * 批量删除专业管理
     * 
     * @param majorIds 需要删除的专业管理主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorByMajorIds(Long[] majorIds)
    {
        return stuMajorMapper.deleteStuMajorByMajorIds(majorIds);
    }

    /**
     * 删除专业管理信息
     * 
     * @param majorId 专业管理主键
     * @return 结果
     */
    @Override
    public int deleteStuMajorByMajorId(Long majorId)
    {
        return stuMajorMapper.deleteStuMajorByMajorId(majorId);
    }
}
