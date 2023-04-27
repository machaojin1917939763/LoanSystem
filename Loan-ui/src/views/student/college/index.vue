<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学院名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入学院名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院长" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入院长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生人数" prop="totalStudents">
        <el-input
          v-model="queryParams.totalStudents"
          placeholder="请输入学生人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="贷款人数" prop="totalBorrowers">
        <el-input
          v-model="queryParams.totalBorrowers"
          placeholder="请输入贷款人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上交合同数" prop="totalContracts">
        <el-input
          v-model="queryParams.totalContracts"
          placeholder="请输入上交合同数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>
    <el-table v-loading="loading" :data="collegeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学院ID" align="center" prop="collegeId" />
      <el-table-column label="学院名称" align="center" prop="name" />
      <el-table-column label="院长" align="center" prop="creator" />
      <el-table-column label="学生人数" align="center" prop="totalStudents" />
      <el-table-column label="贷款人数" align="center" prop="totalBorrowers" />
      <el-table-column label="上交合同数" align="center" prop="totalContracts" />
      <el-table-column label="更新人" align="center" prop="updater" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:college:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:college:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改学院管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学院名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入学院名称" />
        </el-form-item>
        <el-form-item label="院长" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="学生人数" prop="totalStudents">
          <el-input v-model="form.totalStudents" placeholder="请输入学生人数" />
        </el-form-item>
        <el-form-item label="贷款人数" prop="totalBorrowers">
          <el-input v-model="form.totalBorrowers" placeholder="请输入贷款人数" />
        </el-form-item>
        <el-form-item label="上交合同数" prop="totalContracts">
          <el-input v-model="form.totalContracts" placeholder="请输入上交合同数" />
        </el-form-item>
        <el-form-item label="更新人" prop="updater">
          <el-input v-model="form.updater" placeholder="请输入更新人" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCollege, getCollege, delCollege, addCollege, updateCollege } from "@/api/student/college";

export default {
  name: "College",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学院管理表格数据
      collegeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        creator: null,
        totalStudents: null,
        totalBorrowers: null,
        totalContracts: null,
        updater: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "学院名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学院管理列表 */
    getList() {
      this.loading = true;
      listCollege(this.queryParams).then(response => {
        this.collegeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        collegeId: null,
        name: null,
        creator: null,
        totalStudents: null,
        totalBorrowers: null,
        totalContracts: null,
        createTime: null,
        updater: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.collegeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学院管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const collegeId = row.collegeId || this.ids
      getCollege(collegeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学院管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.collegeId != null) {
            updateCollege(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCollege(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const collegeIds = row.collegeId || this.ids;
      this.$modal.confirm('是否确认删除学院管理编号为"' + collegeIds + '"的数据项？').then(function() {
        return delCollege(collegeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/college/export', {
        ...this.queryParams
      }, `college_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
