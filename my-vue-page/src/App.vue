<template>

  <div class="header-nav">
    <router-link to="/" class="nav-link">🏠 首页</router-link>
    <router-link to="/todo" class="nav-link">📋 任务管理</router-link>
  </div>

  <div class="page-container">
    <router-view />
  </div>
</template>

<script setup>
import { onMounted } from 'vue'
import axios from 'axios'

const loadLocalJson = async () => {
  try {
    const result = await axios.get('/testData.json')
    console.log('拿到的json数据:', result.data.data)
    return result.data.data
  } catch (err) {
    console.error('读取testData.json失败：', err)
    return null
  }
}

onMounted(() => {
  loadLocalJson()
})
</script>

<style scoped>
:root {
  color-scheme: dark;
}

.header-nav {
  background: linear-gradient(135deg, #14292c, #1f3b3f);
  padding: 18px 40px;
  display: flex;
  gap: 32px;
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.4);
}

.nav-link {
  font-size: 17px;
  color: #b2e4e8;
  text-decoration: none;
  padding: 9px 18px;
  border-radius: 10px;
  transition: all 0.3s ease;
}

.nav-link:hover {
  background-color: rgba(102, 224, 212, 0.15);
  color: #71e0d2;
  transform: translateY(-2px);
}

.nav-link.router-link-active {
  background: linear-gradient(135deg, #227c70, #289c8c);
  color: #ffffff;
  font-weight: bold;
  box-shadow: 0 0 12px rgba(40, 156, 140, 0.35);
}

.page-container {
  padding: 32px 40px;
  background-color: #122022;
  min-height: calc(100vh - 110px);
}

@media (max-width: 640px) {
  .header-nav {
    flex-direction: column;
    gap: 14px;
    padding: 16px 22px;
  }
  .page-container {
    padding: 20px;
  }
}
</style>