<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学年" prop="academicYear">
        <el-input
          v-model="queryParams.academicYear"
          placeholder="请输入学年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="贷款金额" prop="loanAmount">
        <el-input
          v-model="queryParams.loanAmount"
          placeholder="请输入贷款金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否放款" prop="isDisbursed">
        <el-input
          v-model="queryParams.isDisbursed"
          placeholder="请输入是否放款"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="放款银行" prop="bankId">
        <el-input
          v-model="queryParams.bankId"
          placeholder="请输入放款银行"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学费" prop="tuitionFee">
        <el-input
          v-model="queryParams.tuitionFee"
          placeholder="请输入学费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="扣款日期" prop="deductionDate">
        <el-date-picker clearable
                        v-model="queryParams.deductionDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择扣款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="放款日期" prop="disbursementDate">
        <el-date-picker clearable
                        v-model="queryParams.disbursementDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择放款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="银行名称" prop="bankName">
        <el-input
          v-model="queryParams.bankName"
          placeholder="请输入银行名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="验证码" prop="verificationCode">
        <el-input
          v-model="queryParams.verificationCode"
          placeholder="请输入验证码"
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="contractList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="合同下载" align="center" prop="contractUrl">
          <template slot-scope="scope">
            <el-button size="mini" @click="downloadFile(scope.row.contractUrl)" type="primary">
              {{ scope.row.academicYear }}
            </el-button>
          </template>
        </el-table-column>
      <el-table-column label="学年" align="center" prop="academicYear" />
      <el-table-column label="贷款金额" align="center" prop="loanAmount" />
      <el-table-column label="是否放款" align="center" prop="isDisbursed" />
      <el-table-column label="放款银行" align="center" prop="bankId" />
      <el-table-column label="学费" align="center" prop="tuitionFee" />
      <el-table-column label="扣款日期" align="center" prop="deductionDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deductionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="放款日期" align="center" prop="disbursementDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.disbursementDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="银行名称" align="center" prop="bankName" />
      <el-table-column label="指定账户" align="center" prop="designatedAccount" />
      <el-table-column label="验证码" align="center" prop="verificationCode" />
      <el-table-column label="身份证号" align="center" prop="idCardNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:contract:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:contract:remove']"
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

  <!-- 添加或修改合同信息管理对话框 -->
  <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="贷款金额" prop="loanAmount">
          <el-input v-model="form.loanAmount" placeholder="请输入贷款金额" />
        </el-form-item>
        <el-form-item label="学费" prop="tuitionFee">
          <el-input v-model="form.tuitionFee" placeholder="请输入学费" />
        </el-form-item>
        <el-form-item label="银行名称" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入银行名称" />
        </el-form-item>
        <el-form-item label="指定账户" prop="designatedAccount">
          <el-input v-model="form.designatedAccount" placeholder="请输入指定账户" />
        </el-form-item>
        <el-form-item label="验证码" prop="verificationCode">
          <el-input v-model="form.verificationCode" placeholder="请输入验证码" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCardNumber">
          <el-input v-model="form.idCardNumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="上传" prop="field" required>
          <el-upload ref="field" :file-list="fieldfileList" :action="fieldAction"
                    :before-upload="fieldBeforeUpload" list-type="picture-card">
            <i class="el-icon-plus"></i>
            <div slot="tip" class="el-upload__tip">只能上传不超过 10MB 的文件</div>
          </el-upload>
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
import { listContract, getContract, delContract, addContract, updateContract } from "@/api/student/contract";

export default {
  name: "check",
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
      // 合同信息管理表格数据
      contractList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractUrl: null,
        academicYear: null,
        studentId: null,
        loanAmount: null,
        isDisbursed: null,
        bankId: null,
        tuitionFee: null,
        deductionDate: null,
        disbursementDate: null,
        bankName: null,
        designatedAccount: null,
        verificationCode: null,
        idCardNumber: null,
        creator: null,
        updater: null,
      },
      // 表单参数
      form: {
      //合同上传参数
      //贷款金额
      loanAmount: '',
      //学费
      tuitionFee: '',
      //银行名称
      bankName: '',
      //指定账号
      designatedAccount: '',
      //验证码
      verificationCode: '',
      //身份证号
      idCardNumber: ''
      },
      // 表单校验
      rules: {
        studentId: [
          { required: true, message: "学生ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合同信息管理列表 */
    getList() {
      this.loading = true;
      listContract(this.queryParams).then(response => {
        this.contractList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //下载东西
    downloadFile(file) {
      let link = document.createElement("a");
      link.href = file;
      link.click();
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        contractUrl: null,
        academicYear: null,
        studentId: null,
        loanAmount: null,
        isDisbursed: null,
        bankId: null,
        tuitionFee: null,
        deductionDate: null,
        disbursementDate: null,
        bankName: null,
        designatedAccount: null,
        verificationCode: null,
        idCardNumber: null,
        creator: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加合同信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getContract(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改合同信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateContract(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false; 
              this.getList();
            });
          } else {
            addContract(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    cancel() {
      this.open = false;
    },
    fieldBeforeUpload(file) {
      const isLt10M = file.size / 1024 / 1024 < 10;
      if (!isLt10M) {
        this.$message.error('上传文件大小不能超过 10MB!');
      }
      return isLt10M;
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除合同信息管理编号为"' + ids + '"的数据项？').then(function() {
        return delContract(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/contract/export', {
        ...this.queryParams
      }, `contract_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
