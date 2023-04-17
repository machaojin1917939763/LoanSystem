package com.loan.web.controller.student;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.loan.system.domain.StuBank;
import com.loan.system.service.IStuBankService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 银行Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/bank")
public class StuBankController extends BaseController
{
    @Autowired
    private IStuBankService stuBankService;

    /**
     * 查询银行列表
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuBank stuBank)
    {
        startPage();
        List<StuBank> list = stuBankService.selectStuBankList(stuBank);
        return getDataTable(list);
    }

    /**
     * 导出银行列表
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:export')")
    @Log(title = "银行", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuBank stuBank)
    {
        List<StuBank> list = stuBankService.selectStuBankList(stuBank);
        ExcelUtil<StuBank> util = new ExcelUtil<StuBank>(StuBank.class);
        util.exportExcel(response, list, "银行数据");
    }

    /**
     * 获取银行详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:query')")
    @GetMapping(value = "/{bankId}")
    public AjaxResult getInfo(@PathVariable("bankId") Long bankId)
    {
        return success(stuBankService.selectStuBankByBankId(bankId));
    }

    /**
     * 新增银行
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:add')")
    @Log(title = "银行", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuBank stuBank)
    {
        return toAjax(stuBankService.insertStuBank(stuBank));
    }

    /**
     * 修改银行
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:edit')")
    @Log(title = "银行", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuBank stuBank)
    {
        return toAjax(stuBankService.updateStuBank(stuBank));
    }

    /**
     * 删除银行
     */
//    @PreAuthorize("@ss.hasPermi('system:bank:remove')")
    @Log(title = "银行", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bankIds}")
    public AjaxResult remove(@PathVariable Long[] bankIds)
    {
        return toAjax(stuBankService.deleteStuBankByBankIds(bankIds));
    }
}
