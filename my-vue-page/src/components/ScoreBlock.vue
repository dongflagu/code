<template>
  <div>
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
        <br/>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const props = defineProps({
  math: Number,
  data: Number,
  score: Number,
  courseList: Array
})

const show1= ref(false)
const show2= ref(false)
const toggleScoreBox1 = () => {
  show1.value = !show1.value;
};
const toggleScoreBox2 = () => {
  show2.value = !show2.value;
};
</script>
