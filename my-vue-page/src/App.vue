<template>
  <router-link to="/">【首页】</router-link>
  &nbsp;
  <router-link to="/todo">【任务管理】</router-link>
  <router-view />
</template>

<script setup>
import axios from 'axios'
async function loadLocalJson() {
  try {
    const result = await axios.get('/testData.json')
    console.log('拿到的json数据:', result.data.data)
  } catch (err) {
    console.log('读取失败：', err)
  }
}
loadLocalJson()
</script>
