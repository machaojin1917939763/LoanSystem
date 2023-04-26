<template>
  <div banji="upload">
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px"
               label-position="left">
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="客户姓名" prop="name">
                <el-input v-model="formData.name" placeholder="请输入客户姓名" clearable
                          prefix-icon='el-icon-user-solid' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="性别" prop="sex">

                <el-select v-model="formData.sex" placeholder="请选择性别">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>

              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="客户学号" prop="number">
                <el-input v-model="formData.number" placeholder="请输入10位客户学号" clearable
                          prefix-icon='el-icon-bank-card' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="身份证号" prop="idcard">
                <el-input v-model="formData.idcard" placeholder="请输入18位身份证号" clearable
                          prefix-icon='el-icon-bank-card' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="所属院系" prop="college">
                <el-select v-model="formData.college" placeholder="请选择所属院系" clearable
                           :style="{width: '100%'}">
                  <el-option
                    v-for="(item, index) in collegeList"
                    :key="index"
                    :label="item.name"
                    :value="item.collegeId"
                    :disabled="item.disabled">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属专业" prop="major">
                <el-select v-model="formData.major" placeholder="请选择所属专业" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in majorList" :key="index" :label="item.name"
                             :value="item.majorId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属年级" prop="grade">
                <el-select v-model="formData.grade" placeholder="请选择所属年级" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in gradeList" :key="index" :label="item.name"
                             :value="item.gradeId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属班级" prop="class">
                <el-select v-model="formData.class" placeholder="请选择所属班级" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in banjiList" :key="index" :label="item.name"
                             :value="item.classId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="贷款年份" prop="time">
                <el-input v-model="formData.time" placeholder="请输入贷款年份" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开户银行" prop="bank">
                <el-input v-model="formData.bank" placeholder="请输入开户银行" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="银行账号" prop="account">
                <el-input v-model="formData.account" placeholder="请输入银行账号" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="贷款金额" prop="money">
                <el-input v-model="formData.money" placeholder="请输入贷款金额" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="学费金额" prop="school">
                <el-input v-model="formData.school" placeholder="请输入学费金额" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="校验码" prop="loanAmount">
                <el-input v-model="formData.loanAmount" placeholder="请输入校验码" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="15">
              <el-form-item label="合同附件" prop="pdf" required>

                <el-upload
                  drag
                  multiple
                  :action="uploadFileUrl"
                  :before-upload="handleBeforeUpload"
                  :file-list="formData.fileList"
                  :limit="limit"
                  :on-error="handleUploadError"
                  :on-exceed="handleExceed"
                  :on-success="handleUploadSuccess"
                  :show-file-list="false"
                  :headers="headers"
                  banji="upload-file-uploader"
                  ref="fileUpload"
                >
                  <!-- 上传按钮 -->
                  <i banji="el-icon-upload"></i>
                  <!-- 上传提示 -->
                  <div banji="el-upload__tip" slot="tip" v-if="showTip">
                    请上传
                    <template v-if="fileSize"> 大小不超过 <b style="color: #f56c6c">{{ fileSize }}MB</b></template>
                    <template v-if="fileType"> 格式为 <b style="color: #f56c6c">{{ fileType.join("/") }}</b></template>
                    的文件
                  </div>
                </el-upload>
                <!-- 文件列表 -->
                <transition-group banji="upload-file-list el-upload-list el-upload-list--text" name="el-fade-in-linear"
                                  tag="ul">
                  <li :key="file.url" banji="el-upload-list__item ele-upload-list__item-content"
                      v-for="(file, index) in formData.fileList">
                    <el-link :href="`${baseUrl}${file.url}`" :underline="false" target="_blank">
                      <span banji="el-icon-document"> {{ getFileName(file.name) }} </span>
                    </el-link>
                    <div banji="ele-upload-list__item-content-action">
                      <el-link :underline="false" @click="handleDelete(index)" type="danger">删除</el-link>
                    </div>
                  </li>
                </transition-group>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
  </div>
</template>

<script>
import {fieldcollegeFun, fieldmajorFun, fieldgradeFun, fieldclassFun} from "@/api/student/upload";
import {addContractPact} from '@/api/student/contract'
import {getToken} from "@/utils/auth";

export default {
  components: {},
  props: {
    // 值
    value: [String, Object, Array],
    // 数量限制
    limit: {
      type: Number,
      default: 5,
    },
    // 大小限制(MB)
    fileSize: {
      type: Number,
      default: 5,
    },
    // 文件类型, 例如['png', 'jpg', 'jpeg']
    fileType: {
      type: Array,
      default: () => ["doc", "xls", "ppt", "txt", "pdf", 'png', 'jpg', 'jpeg'],
    },
    // 是否显示提示
    isShowTip: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      formData: {
        fileList: [],
      },
      // rules: {
      //   name: [{
      //     required: true,
      //     message: '请输入客户姓名',
      //     trigger: 'blur'
      //   },{
      //     pattern: /^[\u4e00-\u9fa5a-zA-Z]+$/,
      //     message: '请输入合法姓名',
      //     trigger: 'blur'
      //   }],
      //   sex: [{
      //     required: true,
      //     message: '性别不能为空',
      //     trigger: 'change'
      //   }],
      //   number: [{
      //     required: true,
      //     message: '请输入10位客户学号',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{10}$/,
      //     message: '请输入合法学号',
      //     trigger: 'blur'
      //   }],
      //   idcard: [{
      //     required: true,
      //     message: '请输入18位身份证号',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{17}[0-9a-zA-Z]$/,
      //     message: '请输入合法身份证号',
      //     trigger: 'blur'
      //   }],
      //   college: [{
      //     required: true,
      //     message: '请选择所属院系',
      //     trigger: 'change'
      //   }],
      //   major: [{
      //     required: true,
      //     message: '请选择所属专业',
      //     trigger: 'change'
      //   }],
      //   grade: [{
      //     required: true,
      //     message: '请选择所属年级',
      //     trigger: 'change'
      //   }],
      //   banji: [{
      //     required: true,
      //     message: '请选择所属班级',
      //     trigger: 'change'
      //   }],
      //   time: [{
      //     required: true,
      //     message: '请输入贷款年份',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{4}$/,
      //     message: '请输入合法年份',
      //     trigger: 'blur'
      //   }],
      //   bank: [{
      //     required: true,
      //     message: '请输入开户银行',
      //     trigger: 'blur'
      //   }],
      //   account: [{
      //     required: true,
      //     message: '请输入银行账号',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{19}$/,
      //     message: '请输入合法账号',
      //     trigger: 'blur'
      //   }],
      //   monsy: [{
      //     required: true,
      //     message: '请输入贷款金额',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{3,6}$/,
      //     message: '请输入合法金额',
      //     trigger: 'blur'
      //   }],
      //   school: [{
      //     required: true,
      //     message: '请输入学费金额',
      //     trigger: 'blur'
      //   }, {
      //     pattern: /^\d{3,6}$/,
      //     message: '请输入合法金额',
      //     trigger: 'blur'
      //   }],
      // },
      number: 0,
      uploadList: [],
      baseUrl: process.env.VUE_APP_BASE_API,
      uploadFileUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传文件服务器地址
      headers: {
        Authorization: "Bearer " + getToken(),
      },
      collegeList: [],
      majorList: [],
      banjiList: [],
      gradeList: [],
      options: [{
        value: '1',
        label: '男'
      },
        {
          value: '2',
          label: '女'
        }],
    }
  },
  watch: {
    value: {
      handler(val) {
        if (val) {
          let temp = 1;
          // 首先将值转为数组
          const list = Array.isArray(val) ? val : this.value.split(',');
          // 然后将数组转为对象数组
          this.formData.fileList = list.map(item => {
            if (typeof item === "string") {
              item = {name: item, url: item};
            }
            item.uid = item.uid || new Date().getTime() + temp++;
            return item;
          });
        } else {
          this.formData.fileList = [];
          return [];
        }
      },
      deep: true,
      immediate: true
    }
  },
  computed: {
    // 是否显示提示
    showTip() {
      return this.isShowTip && (this.fileType || this.fileSize);
    },
  },
  created() {
    this.getListCollege()
    this.getListMajor()
    this.getListGrade()
    this.getListbanji()
  },
  mounted() {
  },
  methods: {
    submitForm() {
      // TODO 提交表单
      console.log("formData")
      addContractPact(this.formData).then((res)=>{
        if (res.data().code === 200){
          this.$message.success("上传成功")
        }else {
          this.$message.error("上传失败")
        }
      })
      //TODO 文件上传
      console.log(this.formData)
      this.$refs['elForm'].validate(valid => {
        if (!valid) return

      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    fieldimageBeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 5
      if (!isRightSize) {
        this.$message.error('文件大小超过 5MB')
      }
      let isAccept = new RegExp('image/*').test(file.type)
      if (!isAccept) {
        this.$message.error('应该选择image/*类型的文件')
      }
      return isRightSize && isAccept
    },
    getListCollege() {
      fieldcollegeFun().then(res => {
        this.collegeList = res.rows
      })
    },
    getListGrade() {
      fieldgradeFun().then(res => {
        this.gradeList = res.rows
      })
    },
    getListMajor() {
      fieldmajorFun().then(res => {
        this.majorList = res.rows
      })
    },
    getListbanji() {
      fieldclassFun().then(res => {
        this.banjiList = res.rows
      })
    },
    // 上传前校检格式和大小
    handleBeforeUpload(file) {
      // 校检文件类型
      if (this.fileType) {
        const fileName = file.name.split('.');
        const fileExt = fileName[fileName.length - 1];
        const isTypeOk = this.fileType.indexOf(fileExt) >= 0;
        if (!isTypeOk) {
          this.$modal.msgError(`文件格式不正确, 请上传${this.fileType.join("/")}格式文件!`);
          return false;
        }
      }
      // 校检文件大小
      if (this.fileSize) {
        const isLt = file.size / 1024 / 1024 < this.fileSize;
        if (!isLt) {
          this.$modal.msgError(`上传文件大小不能超过 ${this.fileSize} MB!`);
          return false;
        }
      }
      this.$modal.loading("正在上传文件，请稍候...");
      this.number++;
      return true;
    },
    // 文件个数超出
    handleExceed() {
      this.$modal.msgError(`上传文件数量不能超过 ${this.limit} 个!`);
    },
    // 上传失败
    handleUploadError(err) {
      this.$modal.msgError("上传文件失败，请重试");
      this.$modal.closeLoading()
    },
    // 上传成功回调
    handleUploadSuccess(res, file) {
      if (res.code === 200) {
        this.uploadList.push({name: res.fileName, url: res.fileName});
        this.uploadedSuccessfully();
      } else {
        this.number--;
        this.$modal.closeLoading();
        this.$modal.msgError(res.msg);
        this.$refs.fileUpload.handleRemove(file);
        this.uploadedSuccessfully();
      }
    },
    // 删除文件
    handleDelete(index) {
      this.formData.fileList.splice(index, 1);
      this.$emit("input", this.listToString(this.formData.fileList));
    },
    // 上传结束处理
    uploadedSuccessfully() {
      if (this.number > 0 && this.uploadList.length === this.number) {
        this.formData.fileList = this.formData.fileList.concat(this.uploadList);
        this.uploadList = [];
        this.number = 0;
        this.$emit("input", this.listToString(this.formData.fileList));
        this.$modal.closeLoading();
      }
    },
    // 获取文件名称
    getFileName(name) {
      if (name.lastIndexOf("/") > -1) {
        return name.slice(name.lastIndexOf("/") + 1);
      } else {
        return "";
      }
    },
    // 对象转成指定字符串分隔
    listToString(list, separator) {
      let strs = "";
      separator = separator || ",";
      for (let i in list) {
        strs += list[i].url + separator;
      }
      return strs != '' ? strs.substr(0, strs.length - 1) : '';
    },
  },
}
</script>
<style scoped lang="scss">
.upload {
  margin: 0 auto;
  max-width: 1010px;
}
</style>
