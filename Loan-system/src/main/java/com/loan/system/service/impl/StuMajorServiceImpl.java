package com.loan.system.service.impl;

import java.util.List;
import com.loan.common.utils.DateUtils;
import com.loan.system.domain.StuCollege;
import com.loan.system.mapper.StuCollegeMapper;
import com.loan.system.mapper.SysRoleMapper;
import com.loan.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.loan.system.mapper.StuMajorMapper;
import com.loan.system.domain.StuMajor;
import com.loan.system.service.IStuMajorService;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private StuCollegeMapper stuCollegeMapper;


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
        List<StuMajor> stuMajors = stuMajorMapper.selectStuMajorList(stuMajor);
        for (StuMajor major : stuMajors) {
            String collegeId = major.getCollegeId();
            StuCollege stuCollege = stuCollegeMapper.selectStuCollegeByCollegeId(Long.parseLong(collegeId));
            if (stuCollege!=null){
                major.setCollegeId(stuCollege.getName());
            }else {
                return null;
            }

        }
        return stuMajors;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        stuMajor.setCreator(name);
        stuMajor.setUpdater(name);
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
