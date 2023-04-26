<template>
  <div class="upload">
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-col :span="14">
          <el-row gutter="15">
            <el-col :span="19">
              <el-form-item label="日期选择" prop="fieldyear">
                <el-date-picker v-model="formData.fieldyear" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                  :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="19">
              <el-form-item label="单行文本" prop="fieldon">
                <el-input v-model="formData.fieldon" placeholder="请输入单行文本" clearable
                  :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="19">
              <el-form-item label="单行文本" prop="fieldid">
                <el-input v-model="formData.fieldid" placeholder="请输入单行文本" clearable
                  :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="19">
              <el-form-item label="单行文本" prop="fieldmoney1">
                <el-input v-model="formDatafieldmoney1" placeholder="请输入单行文本" clearable
                  :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="19">
              <el-form-item label="上传" prop="fieldmoney2" required>
                <el-upload ref="fieldmoney2" :file-list="fieldmoney2fileList" :action="fieldmoney2Action"
                  :before-upload="fieldmoney2BeforeUpload" list-type="picture-card">
                  <i class="el-icon-plus"></i>
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
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field108: null,
        field110: undefined,
        field107: undefined,
        field109: undefined,
        field103: null,
      },
      rules: {
        field108: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        field110: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field107: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field109: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
      },
      field103Action: 'https://jsonplaceholder.typicode.com/posts/',
      field103fileList: [],
    }
  },
  computed: {},
  watch: {},
  created() {},
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
    field103BeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return isRightSize
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
