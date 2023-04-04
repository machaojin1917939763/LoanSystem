package com.ruoyi.web.controller.student;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StuMajor;
import com.ruoyi.system.service.IStuMajorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/major")
public class StuMajorController extends BaseController
{
    @Autowired
    private IStuMajorService stuMajorService;

    /**
     * 查询专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuMajor stuMajor)
    {
        startPage();
        List<StuMajor> list = stuMajorService.selectStuMajorList(stuMajor);
        return getDataTable(list);
    }

    /**
     * 导出专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:major:export')")
    @Log(title = "专业管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuMajor stuMajor)
    {
        List<StuMajor> list = stuMajorService.selectStuMajorList(stuMajor);
        ExcelUtil<StuMajor> util = new ExcelUtil<StuMajor>(StuMajor.class);
        util.exportExcel(response, list, "专业管理数据");
    }

    /**
     * 获取专业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:major:query')")
    @GetMapping(value = "/{majorId}")
    public AjaxResult getInfo(@PathVariable("majorId") Long majorId)
    {
        return success(stuMajorService.selectStuMajorByMajorId(majorId));
    }

    /**
     * 新增专业管理
     */
    @PreAuthorize("@ss.hasPermi('system:major:add')")
    @Log(title = "专业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMajor stuMajor)
    {
        return toAjax(stuMajorService.insertStuMajor(stuMajor));
    }

    /**
     * 修改专业管理
     */
    @PreAuthorize("@ss.hasPermi('system:major:edit')")
    @Log(title = "专业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMajor stuMajor)
    {
        return toAjax(stuMajorService.updateStuMajor(stuMajor));
    }

    /**
     * 删除专业管理
     */
    @PreAuthorize("@ss.hasPermi('system:major:remove')")
    @Log(title = "专业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{majorIds}")
    public AjaxResult remove(@PathVariable Long[] majorIds)
    {
        return toAjax(stuMajorService.deleteStuMajorByMajorIds(majorIds));
    }
}
