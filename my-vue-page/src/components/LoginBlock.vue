<template>
  <div>
    <label>姓名：</label>
    <input placeholder="请输入你的名字" v-model="inputName">
    <label>学号：</label>
    <input placeholder="请输入你的学号" v-model="form.inputId">
    <label>选择校区：</label>
    <select v-model="form.selectCity">
      <option value="">请选择校区</option>
      <option value="中山学院">中山学院</option>
    </select>
    <button @click="submitForm">登录</button>
  </div>
</template>

<script setup>
import {ref, reactive} from 'vue'
const inputName=ref("")
const form=reactive({
  inputId : "",
  selectCity : ""
})

const emit = defineEmits(['loginSubmit'])

const submitForm = () => {
  if(inputName.value.trim() === ""){
    alert("姓名输入框不能为空！");
    return;
  }
  if(form.inputId.length !== 8){
    alert("学号必须是8位数字！");
    return;
  }
  emit('loginSubmit',{
    userName: inputName.value,
    userId: form.inputId,
    city: form.selectCity
  })
}
</script>
