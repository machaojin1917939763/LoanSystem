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
import com.loan.system.domain.StuCustomer;
import com.loan.system.service.IStuCustomerService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 客户信息管理Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/customer")
public class StuCustomerController extends BaseController
{
    @Autowired
    private IStuCustomerService stuCustomerService;

    /**
     * 查询客户信息管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuCustomer stuCustomer)
    {
        startPage();
        List<StuCustomer> list = stuCustomerService.selectStuCustomerList(stuCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户信息管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    @Log(title = "客户信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuCustomer stuCustomer)
    {
        List<StuCustomer> list = stuCustomerService.selectStuCustomerList(stuCustomer);
        ExcelUtil<StuCustomer> util = new ExcelUtil<StuCustomer>(StuCustomer.class);
        util.exportExcel(response, list, "客户信息管理数据");
    }

    /**
     * 获取客户信息管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Long customerId)
    {
        return success(stuCustomerService.selectStuCustomerByCustomerId(customerId));
    }

    /**
     * 新增客户信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    @Log(title = "客户信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuCustomer stuCustomer)
    {
        return toAjax(stuCustomerService.insertStuCustomer(stuCustomer));
    }

    /**
     * 修改客户信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    @Log(title = "客户信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuCustomer stuCustomer)
    {
        return toAjax(stuCustomerService.updateStuCustomer(stuCustomer));
    }

    /**
     * 删除客户信息管理
     */
//    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    @Log(title = "客户信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Long[] customerIds)
    {
        return toAjax(stuCustomerService.deleteStuCustomerByCustomerIds(customerIds));
    }
}
