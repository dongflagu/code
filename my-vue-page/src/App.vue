<script setup>
import { ref,watch,onMounted, reactive,computed } from 'vue'
import ScoreBlock from './components/ScoreBlock.vue'
import LoginBlock from './components/LoginBlock.vue'

onMounted(() => {
  console.log("页面初始化成功")
})
const name="电子科技大学中山学院教务系统"
const major="计算机科学与技术"
const math=82
const data=87
const score=3.32
const book="/book1.jpg"
const titleColor = "#ff4500";
const titleFontSize = 20;
const ans =ref(false)
const ans1 =ref(false)
const formCache = ref({
  userName: "",
  userId: "",
  city: ""
})
const courseList = [
  { id: 1, name: "高等数学上", score: 86 },
  { id: 2, name: "程序设计基础", score: 90 },
  { id: 3, name: "程序设计实践", score: 92 },
  { id: 4, name: "计算机导论", score: 70 }
];

const handleLogin = (info)=>{
  alert(`登录成功！姓名：${info.userName}，学号：${info.userId}，校区：${info.city}`);
  ans.value=true
  ans1.value=true
  formCache.value.userName = info.userName
  formCache.value.userId = info.userId
  formCache.value.city = info.city
  setTimeout(()=>{
    ans1.value = false
  },3000)
};
</script>

<style scoped>
.page-box{
  width: 90%;
  margin: 20px auto;
  background-color: #68a1e1ff;
  color:black;
}
.normal-box{
  padding: 10px;
  border: 1px solid #1e54de;
}
.active-box{
  padding: 10px;
  color:blue;
  border: 2px solid #409eff;
  background-color: #a4cca5;
}
button{
  padding: 6px 14px;
  margin: 4px;
  cursor: pointer;
}
input, select{
  padding: 5px;
  margin: 4px;
}
h3{
  color:pink;
}
</style>

<template>
  <div
  class="normal-box" 
  :class="{ 'active-box': ans }"
>
<h3>{{name}}</h3>
<div :title="major">悬浮查看专业</div>
<ScoreBlock 
  :math="math"
  :data="data"
  :score="score"
  :courseList="courseList"
/>
<LoginBlock @loginSubmit="handleLogin"/>

  <div v-if="ans1">
    <p>登录成功!(3s后消失)</p>  
  </div>
  <div v-if="ans">
  <p>上次登录:&nbsp姓名:{{formCache.userName}}&nbsp学号:{{formCache.userId}}&nbsp校区:{{formCache.city}}</p>
  </div>
  <h3 :style="{ color: titleColor, fontSize: titleFontSize + 'px' }">
    欢迎报考电子科技大学中山学院
  </h3>
  <div 
    :style="{
      color:'blue',
      height: '30px',
      backgroundColor: ans ? '#03d06aff' : '#cf0606ff'
    }"
  >
  待到功成与名就，生吃黄连苦也甜
  </div>
  <br>
<img :src="book" style="width:500px;" alt="香山书院">
</div>
</template>
