
<template> <div class="profile"> <div class="header"> <h1 class="title">{{ userName }}</h1> <div class="avatar"> <img :src="avatar" alt="avatar"> </div> </div> <div class="info-container"> <div class="info-row"> <div class="info-label">用户ID:</div> <div class="info-value">{{ userId }}</div> </div> <div class="info-row"> <div class="info-label">用户昵称:</div> <div class="info-value">{{ nickName }}</div> </div> <div class="info-row"> <div class="info-label">用户类型:</div> <div class="info-value">{{ userType }}</div> </div> <div class="info-row"> <div class="info-label">用户邮箱:</div> <div class="info-value">{{ email }}</div> </div> <div class="info-row"> <div class="info-label">手机号码:</div> <div class="info-value">{{ phoneNumber }}</div> </div> <div class="info-row"> <div class="info-label">用户性别:</div> <div class="info-value">{{ gender }}</div> </div> <div class="info-row"> <div class="info-label">最后登录时间:</div> <div class="info-value">{{ lastLogin }}</div> </div> <div class="info-row"> <div class="info-label">创建时间:</div> <div class="info-value">{{ createTime }}</div> </div> </div> </div> </template>
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
</style>


<script>
export default {
  data() {
    return {
      userId: 1,
      userName: "admin",
      nickName: "管理员",
      userType: "00",
      email: "admin@example.com",
      phoneNumber: "12345678901",
      gender: "男",
      avatar: "https://local-imge.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.jpg",
      lastLogin: "2022-04-08 10:30:00",
      createTime: "2021-01-01 00:00:00",
    };
  },
};
</script>
