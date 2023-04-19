package com.loan.system.service;

import java.text.ParseException;
import java.util.List;
import com.loan.system.domain.StuContract;
import com.loan.system.domain.vo.PactVo;

import javax.servlet.http.Cookie;

/**
 * 合同信息管理Service接口
 * 
 * @author loan
 * @date 2023-04-04
 */
public interface IStuContractService 
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
     * 批量删除合同信息管理
     * 
     * @param ids 需要删除的合同信息管理主键集合
     * @return 结果
     */
    public int deleteStuContractByIds(Long[] ids);

    /**
     * 删除合同信息管理信息
     * 
     * @param id 合同信息管理主键
     * @return 结果
     */
    public int deleteStuContractById(Long id);

    /**
     * 合同上传
     *
     * @param pactVo  合同信息
     * @param cookies
     * @return 结果
     */
    int addContract(PactVo pactVo, Cookie[] cookies) throws ParseException;
}
