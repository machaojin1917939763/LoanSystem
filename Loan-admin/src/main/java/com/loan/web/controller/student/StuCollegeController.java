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
import com.loan.system.domain.StuCollege;
import com.loan.system.service.IStuCollegeService;
import com.loan.common.utils.poi.ExcelUtil;
import com.loan.common.core.page.TableDataInfo;

/**
 * 学院管理Controller
 * 
 * @author loan
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/system/college")
public class StuCollegeController extends BaseController
{
    @Autowired
    private IStuCollegeService stuCollegeService;

    /**
     * 查询学院管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:college:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuCollege stuCollege)
    {
        startPage();
        List<StuCollege> list = stuCollegeService.selectStuCollegeList(stuCollege);
        return getDataTable(list);
    }

    /**
     * 导出学院管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:college:export')")
    @Log(title = "学院管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuCollege stuCollege)
    {
        List<StuCollege> list = stuCollegeService.selectStuCollegeList(stuCollege);
        ExcelUtil<StuCollege> util = new ExcelUtil<StuCollege>(StuCollege.class);
        util.exportExcel(response, list, "学院管理数据");
    }

    /**
     * 获取学院管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:college:query')")
    @GetMapping(value = "/{collegeId}")
    public AjaxResult getInfo(@PathVariable("collegeId") Long collegeId)
    {
        return success(stuCollegeService.selectStuCollegeByCollegeId(collegeId));
    }

    /**
     * 新增学院管理
     */
//    @PreAuthorize("@ss.hasPermi('system:college:add')")
    @Log(title = "学院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuCollege stuCollege)
    {
        return toAjax(stuCollegeService.insertStuCollege(stuCollege));
    }

    /**
     * 修改学院管理
     */
//    @PreAuthorize("@ss.hasPermi('system:college:edit')")
    @Log(title = "学院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuCollege stuCollege)
    {
        return toAjax(stuCollegeService.updateStuCollege(stuCollege));
    }

    /**
     * 删除学院管理
     */
//    @PreAuthorize("@ss.hasPermi('system:college:remove')")
    @Log(title = "学院管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{collegeIds}")
    public AjaxResult remove(@PathVariable Long[] collegeIds)
    {
        return toAjax(stuCollegeService.deleteStuCollegeByCollegeIds(collegeIds));
    }
}
