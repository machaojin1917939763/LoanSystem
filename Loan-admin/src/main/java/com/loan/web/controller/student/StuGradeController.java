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
import com.loan.system.domain.StuGrade;
import com.loan.system.service.IStuGradeService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 年级管理Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/grade")
public class StuGradeController extends BaseController
{
    @Autowired
    private IStuGradeService stuGradeService;

    /**
     * 查询年级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuGrade stuGrade)
    {
        startPage();
        List<StuGrade> list = stuGradeService.selectStuGradeList(stuGrade);
        return getDataTable(list);
    }

    /**
     * 导出年级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "年级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuGrade stuGrade)
    {
        List<StuGrade> list = stuGradeService.selectStuGradeList(stuGrade);
        ExcelUtil<StuGrade> util = new ExcelUtil<StuGrade>(StuGrade.class);
        util.exportExcel(response, list, "年级管理数据");
    }

    /**
     * 获取年级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{gradeId}")
    public AjaxResult getInfo(@PathVariable("gradeId") Long gradeId)
    {
        return success(stuGradeService.selectStuGradeByGradeId(gradeId));
    }

    /**
     * 新增年级管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "年级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuGrade stuGrade)
    {
        return toAjax(stuGradeService.insertStuGrade(stuGrade));
    }

    /**
     * 修改年级管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "年级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuGrade stuGrade)
    {
        return toAjax(stuGradeService.updateStuGrade(stuGrade));
    }

    /**
     * 删除年级管理
     */
    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "年级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gradeIds}")
    public AjaxResult remove(@PathVariable Long[] gradeIds)
    {
        return toAjax(stuGradeService.deleteStuGradeByGradeIds(gradeIds));
    }
}
