
<template> 
<div class="profile"> 
  <div class="header"> 
    <div class="avatar"> <img :src="avatar" alt="avatar"> </div> 
  </div> 
        <div class="info-container"> 
          <form @submit.prevent="submit">
          <div class="info-row"> 
            <div class="info-label">昵称:</div> 
            <div class="info-value">
              <!-- <input type="text" v-model="nickName" /> -->
              <el-input
                v-model="nickName"
                placeholder="请输入昵称"
                clearable
                @keyup.enter.native="handleQuery"
              />
           </div> 
       </div> 
        <div class="info-row"> 
          <div class="info-label">类型:</div> 
          <div class="info-value">
            <!-- <input type="text" v-model="userType" /> -->
            <el-input
              v-model="userType"
              placeholder="请输入类型"
              clearable
              @keyup.enter.native="handleQuery"
            />
          </div> 
        </div> 
        <div class="info-row">
           <div class="info-label">姓名:</div> 
           <div class="info-value">
            <!-- <input type="text" v-model="userName" /> -->
            <el-input
              v-model="userName"
              placeholder="请输入姓名"
              clearable
              @keyup.enter.native="handleQuery"
            />
           </div> 
        </div> 
        <div class="info-row">
           <div class="info-label">性别:</div> 
            <el-select v-model="selectedSex" placeholder="请选择性别" >
              <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option> 
            </el-select>
        </div> 
        <div class="info-row">
          <div class="info-label">所属学院:</div>
          <div class="info-value" >
            <el-select v-model="selectedCollege" placeholder="请选择所属学院">
               <el-option v-for="(item, index) in collegeOptions" :key="index"  :label="item.name"
                            :value="item.collegeId"  :disabled="item.disabled">
                  </el-option>
            </el-select>
          </div>
        </div>
        <div class="info-row">
          <div class="info-label">所属专业:</div>
          <div class="info-value" >
            <el-select v-model="selectedMajor"  placeholder="请选择所属专业">
               <el-option v-for="(item, index) in majorOptions" :key="index" :label="item.name"
                             :value="item.majorId" :disabled="item.disabled"></el-option>
            </el-select>
          </div>
        </div>
        <div class="info-row">
          <div class="info-label">所属年级:</div>
          <div class="info-value"  >
            <el-select v-model="selectedGrade"  placeholder="请选择所属年级">
               <el-option v-for="(item, index) in gradeOptions" :key="index" :label="item.name"
                             :value="item.gradeId" :disabled="item.disabled"></el-option>
            </el-select>
          </div>
        </div>
        <div class="info-row">
          <div class="info-label">所属班级:</div>
          <div class="info-value" >
            <el-select v-model="selectedClass" placeholder="请选择所属班级">
               <el-option v-for="(item, index) in classOptions" :key="index" :label="item.name"
                             :value="item.classId" :disabled="item.disabled"></el-option>
            </el-select>
          </div>
        </div>
        <div class="info-row"> 
          <div class="info-label">用户邮箱:</div> 
          <div class="info-value"> 
            <!-- <input type="text" v-model="email" /> -->
            <el-input
              v-model="email"
              placeholder="请输入邮箱"
              clearable
              @keyup.enter.native="handleQuery"
            />
          </div> 
        </div> 
        <div class="info-row"> 
          <div class="info-label">手机号码:</div> 
          <div class="info-value">
            <!-- <input type="text" v-model="phoneNumber" /> -->
            <el-input
              v-model="phoneNumber"
              placeholder="请输入手机号码"
              clearable
              @keyup.enter.native="handleQuery"
            />
          </div> 
        </div> 
        <div class="info-row"> 
          <div class="info-label">最后登录时间:</div> 
          <div class="info-value">{{ lastLogin }}</div> 
        </div> 
        <div class="info-row"> 
          <div class="info-label">创建时间:</div> 
          <div class="info-value">{{ createTime }}</div> 
        </div> 
        <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="submitForm">确 定</el-button>
            <el-button @click="cancel">取 消</el-button>
        </div>
    </form>
    </div>  
</div>
</template>

<style>
/* 整体布局 */
body {
  font-family: 'Helvetica', 'Arial', sans-serif;
  line-height: 1.6;
  color: #333;
  background-color: #f5f5f5;
  margin: 0;
  padding: 0;
}

/* 信息容器 */
.container {
  max-width: 800px;
  margin: 40px auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
}

/* 标题 */
h1 {
  font-size: 2.5em;
  margin: 0 0 20px;
}

/* 副标题 */
h2 {
  font-size: 1.8em;
  margin: 0 0 10px;
}

/* 文本 */
p {
  font-size: 1.2em;
  margin: 0 0 20px;
}

/* 链接 */
a {
  color: #007bff;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

/* 列表 */
ul {
  list-style-type: none;
  padding: 0;
}

/* 列表项 */
li {
  font-size: 1.2em;
  padding: 5px 0;
}

/* 图标 */
.icon {
  font-size: 1.2em;
  margin-right: 10px;
  color: #333;
}
.profile {
  width: 600px;
  margin: 0 auto;
  font-size: 16px;
}
.header {
  text-align: center;
}
.title {
  margin: 0;
  font-size: 32px;
}
.avatar {
  width: 128px;
  height: 128px;
  border-radius: 50%;
  overflow: hidden;
  margin: 24px auto;
}
.avatar img {
  width: 100%;
}
.info-container {
  background: #f5f5f5;
  padding: 24px;
}
.info-row {
  display: flex;
  margin-bottom: 12px;
  justify-content: space-between;
}
.info-label {
  font-weight: bold;
}
.info-value {
  
  text-align: right;
  color: #555;
}
.submit-btn {
  background-color: #ddd0d7; /* 设置背景颜色 */
  color: white; /* 设置文本颜色 */
  border: none; /* 移除边框 */
  padding: 10px 20px; /* 设置内边距 */
  text-align: center; /* 让文本居中 */
  text-decoration: none; /* 移除下划线 */
  display: inline-block; /* 设置为行内块元素 */
  font-size: 16px; /* 设置字体大小 */
  border-radius: 5px; /* 设置圆角 */
  cursor: pointer; /* 添加鼠标指针效果 */
  transition: background-color 0.3s ease; /* 添加过渡效果 */
}

.submit-btn:hover {
  background-color: #8e3e4d; /* 鼠标悬停时改变背景颜色 */
}
</style>


<script>
import {fieldcollegeFun, fieldmajorFun, fieldgradeFun, fieldclassFun} from "@/api/student/upload";
import axios from 'axios';
import { VueSelect } from 'vue-select';
export default {
  name: 'Profile',
  components: {
    'v-select': VueSelect,
  },
  data() {
    return {
      userName: "",
      nickName: "",
      userType: "",
      email: "",
      phoneNumber: "",
      lastLogin: "",
      createTime: "",
      selectedSex:'',
      selectedCollege: '',
      selectedMajor: '',
      selectedGrade: '',
      selectedClass: '',
      avatar: "https://local-imge.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.jpg",
      options: [{
        value: '1',
        label: '男'
      },
        {
          value: '2',
          label: '女'
        }],
      collegeOptions: [],
      majorOptions: [],
      gradeOptions: [],
      classOptions: [],
    };
  },
  created() {
    this.getListCollege()
    this.getListMajor()
    this.getListGrade()
    this.getListbanji()
  },
  methods: {
    submitForm() {
      // 使用axios库向后端API发送表单数据
      axios.post('/dev-api/system/customer/user', {
        userName:this.userName,
        selectedSex:this.selectedSex,
        nickName: this.nickName,
        userType: this.userType,
        college: this.selectedCollege,
        major: this.selectedMajor,
        grade: this.selectedGrade,
        class: this.selectedClass,
        phoneNumber: this.phone,
        lastLogin:this.lastLogin,
        createTime:this.createTime,
        email: this.email,
      })
        .then(() => {
          alert('提交成功');
        })
        .catch((error) => {
          console.error(error);
          alert('提交失败');
        });
    },
    getListCollege() {
      fieldcollegeFun().then(res => {
        this.collegeOptions = res.rows
      })
    },
    getListGrade() {
      fieldgradeFun().then(res => {
        this.gradeOptions = res.rows
      })
    },
    getListMajor() {
      fieldmajorFun().then(res => {
        this.majorOptions = res.rows
      })
    },
    getListbanji() {
      fieldclassFun().then(res => {
        this.classOptions = res.rows
      })
    },
    
  },
};
</script>
