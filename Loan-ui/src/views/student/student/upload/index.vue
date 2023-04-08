<template>
  <div class="upload">
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px"
               label-position="left">
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="学生姓名" prop="fieldname">
                <el-input v-model="formData.fieldname" placeholder="请输入学生姓名" clearable
                          prefix-icon='el-icon-user-solid' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="性别" prop="fieldsex">
                <el-radio-group v-model="formData.fieldsex" size="medium">
                  <el-radio-button v-for="(item, index) in fieldsexOptions" :key="index" :label="item.value"
                                   :disabled="item.disabled">{{item.label}}</el-radio-button>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="学生学号" prop="fieldnumber">
                <el-input v-model="formData.fieldnumber" placeholder="请输入10位学生学号" clearable
                          prefix-icon='el-icon-bank-card' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="身份证号" prop="fieldsize">
                <el-input v-model="formData.fieldsize" placeholder="请输入18位身份证号" clearable
                          prefix-icon='el-icon-bank-card' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="所属院系" prop="fieldcollege">
                <el-select v-model="formData.fieldcollege" placeholder="请选择所属院系" clearable
                           :style="{width: '100%'}">
                  <el-option
                    v-for="(item, index) in fieldcollegeptions"
                    :key="index"
                    :label="item.name"
                    :value="item.collegeId"
                    :disabled="item.disabled">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属专业" prop="fieldmajor">
                <el-select v-model="formData.fieldmajor" placeholder="请选择所属专业" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in fieldmajorptions" :key="index" :label="item.name"
                             :value="item.majorId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属年级" prop="fieldgrade">
                <el-select v-model="formData.fieldgrade" placeholder="请选择所属年级" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in fieldgradeptions" :key="index" :label="item.name"
                             :value="item.gradeId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属班级" prop="fieldclass">
                <el-select v-model="formData.fieldclass" placeholder="请选择所属班级" clearable
                           :style="{width: '100%'}">
                  <el-option v-for="(item, index) in fieldclassptions" :key="index" :label="item.name"
                             :value="item.classId" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="12">
              <el-form-item label="贷款年份" prop="fieldyear">
                <el-input v-model="formData.fieldyear" placeholder="请输入贷款年份" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开户银行" prop="fieldon">
                <el-input v-model="formData.fieldon" placeholder="请输入开户银行" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="银行账号" prop="fieldid">
                <el-input v-model="formData.fieldid" placeholder="请输入银行账号" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="贷款金额" prop="fieldmoney1">
                <el-input v-model="formData.fieldmoney1" placeholder="请输入贷款金额" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="学费金额" prop="fieldmoney2">
                <el-input v-model="formData.fieldmoney2" placeholder="请输入学费金额" clearable
                          prefix-icon='el-icon-edit' :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="15">
          <el-row gutter="20">
            <el-col :span="15">
              <el-form-item label="合同附件" prop="fieldimage" required>
                <el-upload ref="fieldimage" :file-list="fieldimagefileList" :action="fieldimageAction"
                           :before-upload="fieldimageBeforeUpload" list-type="picture-card" accept="image/*">
                  <i class="el-icon-plus"></i>
                  <div slot="tip" class="el-upload__tip">只能上传不超过 5MB 的image/*文件</div>
                </el-upload>
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
import { fieldcollegeFun,fieldmajorFun,fieldgradeFun,fieldclassFun } from "@/api/student/upload";
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        fieldname: undefined,
        fieldsex: 1,
        fieldnumber: undefined,
        fieldsize: undefined,
        fieldcollege: undefined,
        fieldmajor: undefined,
        fieldgrade: undefined,
        fieldclass: undefined,
        fieldyear: undefined,
        fieldon: undefined,
        fieldid: undefined,
        fieldmoney1: undefined,
        fieldmoney2: undefined,
        fieldimage: null,
      },
      rules: {
        fieldname: [{
          required: true,
          message: '请输入学生姓名',
          trigger: 'blur'
        },{
          pattern: /^[\u4e00-\u9fa5a-zA-Z]+$/,
          message: '请输入合法姓名',
          trigger: 'blur'
        }],
        fieldsex: [{
          required: true,
          message: '性别不能为空',
          trigger: 'change'
        }],
        fieldnumber: [{
          required: true,
          message: '请输入10位学生学号',
          trigger: 'blur'
        }, {
          pattern: /^\d{10}$/,
          message: '请输入合法学号',
          trigger: 'blur'
        }],
        fieldsize: [{
          required: true,
          message: '请输入18位身份证号',
          trigger: 'blur'
        }, {
          pattern: /^\d{17}[0-9a-zA-Z]$/,
          message: '请输入合法身份证号',
          trigger: 'blur'
        }],
        fieldcollege: [{
          required: true,
          message: '请选择所属院系',
          trigger: 'change'
        }],
        fieldmajor: [{
          required: true,
          message: '请选择所属专业',
          trigger: 'change'
        }],
        fieldgrade: [{
          required: true,
          message: '请选择所属年级',
          trigger: 'change'
        }],
        fieldclass: [{
          required: true,
          message: '请选择所属班级',
          trigger: 'change'
        }],
        fieldyear: [{
          required: true,
          message: '请输入贷款年份',
          trigger: 'blur'
        }, {
          pattern: /^\d{4}$/,
          message: '请输入合法年份',
          trigger: 'blur'
        }],
        fieldon: [{
          required: true,
          message: '请输入开户银行',
          trigger: 'blur'
        }],
        fieldid: [{
          required: true,
          message: '请输入银行账号',
          trigger: 'blur'
        }, {
          pattern: /^\d{19}$/,
          message: '请输入合法账号',
          trigger: 'blur'
        }],
        fieldmoney1: [{
          required: true,
          message: '请输入贷款金额',
          trigger: 'blur'
        }, {
          pattern: /^\d{3,6}$/,
          message: '请输入合法金额',
          trigger: 'blur'
        }],
        fieldmoney2: [{
          required: true,
          message: '请输入学费金额',
          trigger: 'blur'
        }, {
          pattern: /^\d{3,6}$/,
          message: '请输入合法金额',
          trigger: 'blur'
        }],
      },
      fieldimageAction: 'https://jsonplaceholder.typicode.com/posts/',
      fieldimagefileList: [],
      fieldsexOptions: [{
        "label": "男",
        "value": 1
      }, {
        "label": "女",
        "value": 2
      }],
      fieldcollegeptions: [],
      fieldmajorptions: [],
      fieldgradeptions: [],
      fieldclassptions: [],
    }
  },
  computed: {},
  watch: {},
  created() {
    this.getListCollege()
    this.getListMajor()
    this.getListGrade()
    this.getListClass()
  },
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
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
        this.fieldcollegeptions = res.rows
      })
    },
    getListGrade() {
      fieldgradeFun().then(res => {
        this.fieldgradeptions = res.rows
      })
    },
    getListMajor() {
      fieldmajorFun().then(res => {
        this.fieldmajorptions = res.rows
      })
    },
    getListClass() {
      fieldclassFun().then(res => {
        this.fieldclassptions = res.rows
      })
    },
  },
}
</script>
<style scoped lang="scss">
.upload {
  margin: 2% 20%;
  width: 100%;
}
</style>
