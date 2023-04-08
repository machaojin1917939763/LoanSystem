<template>
  <div class="profile">
    <div class="header">
      <h1 class="title">{{ userName }}</h1>
      <div class="avatar">
        <img :src="avatar" alt="avatar">
      </div>
    </div>
    <div class="info-container">
      <div class="info-row">
        <div class="info-label">用户ID:</div>
        <div class="info-value">{{ userId }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">用户昵称:</div>
        <div class="info-value">{{ nickName }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">用户类型:</div>
        <div class="info-value">{{ userType }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">用户邮箱:</div>
        <div class="info-value">{{ email }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">手机号码:</div>
        <div class="info-value">{{ phoneNumber }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">用户性别:</div>
        <div class="info-value">{{ gender }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">最后登录时间:</div>
        <div class="info-value">{{ lastLogin }}</div>
      </div>
      <div class="info-row">
        <div class="info-label">创建时间:</div>
        <div class="info-value">{{ createTime }}</div>
      </div>
    </div>
  </div>
</template>

<style>
.profile {
  font-family: Arial, sans-serif;
  height: 100%;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.header {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f8f8f8;
  width: 100%;
  padding: 40px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  z-index: 1;
}

.title {
  font-size: 48px;
  color: #222;
  margin-right: 20px;
}

.avatar {
  width: 200px;
  height: 200px;
  border-radius: 50%;
  overflow: hidden;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.info-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 80%;
  margin-top: -100px;
  padding: 50px;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.info-row {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  width: 100%;
  justify-content: space-between;
}

.info-label {
  font-size: 24px;
  font-weight: bold;
  color: #222;
}

.info-value {
  font-size: 24px;
  color: #555;
}
</style>

<script>
export default {
  data() {
    return {
      userId: 1,
      userName: 'admin',
      nickName: '管理员',
      userType: '00',
      email: 'admin@example.com',
      phoneNumber: '12345678901',
      gender: '男',
      avatar: 'https://local-imge.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.jpg',
      lastLogin: '2022-04-08 10:30:00',
      createTime: '2021-01-01 00:00:00',
    };
  },
};
</script>
