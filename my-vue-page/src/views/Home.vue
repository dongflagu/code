<template>
  <div class="home-wrap">
    <h2>🏠 教务系统登录</h2>
    <div class="box-row">
      <input v-model="userName" placeholder="输入你的名字">
      <button @click="goByQuery">跳转到教务页</button>
    </div>
    <video
        width=600px
        controls
        poster="/naiwa2.png"
        src="/naiwa4.mp4"
        loop
    >
      你的浏览器不支持视频播放
    </video>

    <svg width="700" height="60">
      <defs>
        <linearGradient id="myGrad" x1="0%" y1="0%" x2="100%" y2="0%">
          <stop offset="0%" stop-color="#71e0d2"/>
          <stop offset="100%" stop-color="#348c82"/>
        </linearGradient>
      </defs>
      <text x="350" y="35" text-anchor="middle" font-size="26" fill="url(#myGrad)">零距离的思念是你在我身边</text>
    </svg>

  </div>
</template>
<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const naiwa = "/naiwa2"
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

<!-- scoped写普通样式 -->
<style scoped>
.home-wrap{
  padding:20px;
  text-align:center;
}
.box-row{
  display:flex;
  gap:12px;
  justify-content:center;
  margin-bottom:20px;
}
input {
  height: 44px;
  font-size: 16px;
  padding: 0 14px;
  border-radius: 8px;
  background: #1f3b3f;
  border: 1px solid #365c60;
  color:#b2e4e8;
}
input:focus{
  outline: none;
  border-color:#71e0d2;
  box-shadow: 0 0 0 3px rgba(113, 224, 210,0.2);
}
img{
  width:500px;
  height:300px;
}
button{
  height:44px;
  padding:0 16px;
  background:#227c70;
  color:white;
  border:none;
  border-radius:8px;
  cursor:pointer;
}
button:hover{
  background:#289c8c;
}
</style>

