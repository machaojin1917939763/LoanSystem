package com.loan.web.controller.student;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.system.domain.vo.PactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loan.common.annotation.Log;
import com.loan.common.core.controller.BaseController;
import com.loan.common.core.domain.AjaxResult;
import com.loan.common.enums.BusinessType;
import com.loan.system.domain.StuContract;
import com.loan.system.service.IStuContractService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 合同信息管理Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/contract")
public class StuContractController extends BaseController
{
    @Autowired
    private IStuContractService stuContractService;

    /**
     * 查询合同信息管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuContract stuContract,HttpServletRequest request)
    {
        startPage();
        List<StuContract> list = stuContractService.selectStuContractList(stuContract,request);
        return getDataTable(list);
    }

    /**
     * 导出合同信息管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:export')")
    @Log(title = "合同信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuContract stuContract ,HttpServletRequest request)
    {
        List<StuContract> list = stuContractService.selectStuContractList(stuContract, request);
        ExcelUtil<StuContract> util = new ExcelUtil<StuContract>(StuContract.class);
        util.exportExcel(response, list, "合同信息管理数据");
    }

    /**
     * 获取合同信息管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuContractService.selectStuContractById(id));
    }

    /**
     * 新增合同信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:add')")
    @Log(title = "合同信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuContract stuContract,HttpServletRequest request)
    {
        return toAjax(stuContractService.insertStuContract(stuContract,request));
    }

    /**
     * 新增合同信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:add')")
    @Log(title = "合同信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/pact")
    public AjaxResult addPact(@RequestBody PactVo pactVo, HttpServletRequest request) throws ParseException {
//        return toAjax(stuContractService.insertStuContract(stuContract));
        System.out.println(pactVo);
        Cookie[] cookies = request.getCookies();
        return toAjax(stuContractService.addContract(pactVo,cookies));
    }

    /**
     * 修改合同信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:edit')")
    @Log(title = "合同信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuContract stuContract)
    {
        return toAjax(stuContractService.updateStuContract(stuContract));
    }

    /**
     * 删除合同信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:contract:remove')")
    @Log(title = "合同信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuContractService.deleteStuContractByIds(ids));
    }
}
