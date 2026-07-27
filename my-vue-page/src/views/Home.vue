<template>
  <div style="padding:20px;">
    <h2>🏠 首页</h2>
    <input v-model="userName" placeholder="输入你的名字">
    <button @click="goByQuery">跳转到教务页</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const userName = ref('')

const goByQuery = () => {
  router.push({
    path: '/edu',
    query: {
      name: userName.value
    }
  })
}
</script>
