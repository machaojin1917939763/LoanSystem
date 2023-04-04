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
import com.loan.system.domain.StuLoanDisbursementTime;
import com.loan.system.service.IStuLoanDisbursementTimeService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 放款时间Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/time")
public class StuLoanDisbursementTimeController extends BaseController
{
    @Autowired
    private IStuLoanDisbursementTimeService stuLoanDisbursementTimeService;

    /**
     * 查询放款时间列表
     */
    @PreAuthorize("@ss.hasPermi('system:time:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        startPage();
        List<StuLoanDisbursementTime> list = stuLoanDisbursementTimeService.selectStuLoanDisbursementTimeList(stuLoanDisbursementTime);
        return getDataTable(list);
    }

    /**
     * 导出放款时间列表
     */
    @PreAuthorize("@ss.hasPermi('system:time:export')")
    @Log(title = "放款时间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        List<StuLoanDisbursementTime> list = stuLoanDisbursementTimeService.selectStuLoanDisbursementTimeList(stuLoanDisbursementTime);
        ExcelUtil<StuLoanDisbursementTime> util = new ExcelUtil<StuLoanDisbursementTime>(StuLoanDisbursementTime.class);
        util.exportExcel(response, list, "放款时间数据");
    }

    /**
     * 获取放款时间详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:time:query')")
    @GetMapping(value = "/{timeId}")
    public AjaxResult getInfo(@PathVariable("timeId") Long timeId)
    {
        return success(stuLoanDisbursementTimeService.selectStuLoanDisbursementTimeByTimeId(timeId));
    }

    /**
     * 新增放款时间
     */
    @PreAuthorize("@ss.hasPermi('system:time:add')")
    @Log(title = "放款时间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        return toAjax(stuLoanDisbursementTimeService.insertStuLoanDisbursementTime(stuLoanDisbursementTime));
    }

    /**
     * 修改放款时间
     */
    @PreAuthorize("@ss.hasPermi('system:time:edit')")
    @Log(title = "放款时间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuLoanDisbursementTime stuLoanDisbursementTime)
    {
        return toAjax(stuLoanDisbursementTimeService.updateStuLoanDisbursementTime(stuLoanDisbursementTime));
    }

    /**
     * 删除放款时间
     */
    @PreAuthorize("@ss.hasPermi('system:time:remove')")
    @Log(title = "放款时间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{timeIds}")
    public AjaxResult remove(@PathVariable Long[] timeIds)
    {
        return toAjax(stuLoanDisbursementTimeService.deleteStuLoanDisbursementTimeByTimeIds(timeIds));
    }
}
