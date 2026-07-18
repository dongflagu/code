<script setup>
import { ref } from 'vue'
const name="电子科技大学中山学院教务系统"
const major="计算机科学与技术"
const math=82
const data=87
const score=3.32
const book="/book1.jpg"
const boxclass="page-box"
const show1= ref(false)
const show2= ref(false)
const ans =ref(false)
const ans1 =ref(false)
let inputName = "";
let inputId = "";
let selectCity = "";
const titleColor = "#ff4500";
const titleFontSize = 20;
const boxActiveFlag = true;
const formCache = ref({
  userName: "",
  userId: "",
  city: ""
})
const submitForm = () => {
  if(inputName.trim() === ""){
    alert("姓名输入框不能为空！");
    return;
  }
  if(inputId.length !== 8){
    alert("学号必须是8位数字！");
    return;
  }
  alert(`登录成功！姓名：${inputName}，学号：${inputId}，校区：${selectCity}`);
  ans.value=true
  ans1.value=true
  formCache.value.userName = inputName
  formCache.value.userId = inputId
  formCache.value.city = selectCity
  setTimeout(()=>{
    ans1.value = false
  },3000)
};
const courseList = [
  { id: 1, name: "高等数学上", score: 86 },
  { id: 2, name: "程序设计基础", score: 90 },
  { id: 3, name: "程序设计实践", score: 92 },
  { id: 4, name: "计算机导论", score: 70 }
];
const toggleScoreBox1 = () => {
  show1.value = !show1.value;
};
const toggleScoreBox2 = () => {
  show2.value = !show2.value;
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
  border: 1px solid #ccc;
}
.active-box{
  padding: 10px;
  border: 2px solid #409eff;
  background-color: #f0f7ff;
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
<div :class="boxclass">
<h3>{{name}}</h3>
<div :title="major">悬浮查看专业</div>
<p>总分:{{data+math}}</p>
<div>
    <p v-if="math >= 90">高数评级：优秀</p>
    <p v-else-if="math >= 80">高数评级：良好</p>
    <p v-else-if="math >= 60">高数评级：及格</p>
    <p v-else>高数评级：不及格</p>
  </div>
<p>数据结构是否及格：{{ data >= 60 ? "及格" : "不及格" }}</p>
<button @click="toggleScoreBox1">查看绩点</button>
<button @click="toggleScoreBox2">上学期成绩</button>
<br>
<div v-show="show1">
    <p>绩点：{{score}}</p>
  </div>
  <div v-if="show2">
    <div v-for="(item, index) in courseList" :key="item.id">
      <span>第{{ index + 1 }}门课：</span>
      <span>{{ item.name }} &nbsp;&nbsp;分数：{{ item.score }} 分</span>
      </div>
      </div>
    <label>姓名：</label>
    <input placeholder="请输入你的名字" v-model="inputName">
    <label>学号：</label>
    <input placeholder="请输入你的学号" v-model="inputId">
    <label>选择校区：</label>
    <select v-model="selectCity">
      <option value="">请选择校区</option>
      <option value="中山学院">中山学院</option>
    </select>
  <button @click="submitForm">登录</button>
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
