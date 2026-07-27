<template>
  <div style="width: 800px; margin: 30px auto;">
    <h2>📋 任务管理系统</h2>

    <div style="margin-bottom: 20px; display: flex; gap: 10px;">
      <el-input
        v-model="newTask"
        placeholder="输入新任务名称"
        style="width: 300px;"
        @keyup.enter="addTask"
      />
      <el-button type="primary" @click="addTask">添加任务</el-button>
    </div>

    <div style="margin-bottom: 15px;">
      <el-button :type="filter === 'all' ? 'primary' : ''" @click="filter = 'all'">全部</el-button>
      <el-button :type="filter === 'active' ? 'primary' : ''" @click="filter = 'active'">未完成</el-button>
      <el-button :type="filter === 'done' ? 'primary' : ''" @click="filter = 'done'">已完成</el-button>
      <span style="margin-left: 20px;">共 {{ filteredList.length }} 条</span>
    </div>

    <el-table :data="filteredList" border stripe>
      <el-table-column width="60" align="center">
        <template #default="{ row }">
          <el-checkbox v-model="row.done" @change="toggleDone(row)" />
        </template>
      </el-table-column>
      <el-table-column prop="id" label="编号" width="80" />
      <el-table-column label="任务名称">
        <template #default="{ row }">
          <span :style="{ textDecoration: row.done ? 'line-through' : 'none', color: row.done ? '#999' : '#000' }">
            {{ row.name }}
          </span>
        </template>
      </el-table-column>
      <el-table-column label="状态" width="100" align="center">
        <template #default="{ row }">
          <el-tag :type="row.done ? 'success' : 'warning'">
            {{ row.done ? '已完成' : '进行中' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="center">
        <template #default="{ row, $index }">
          <el-button size="small" @click="openEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="deleteTask(row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 编辑弹窗 -->
    <el-dialog v-model="editVisible" title="编辑任务" width="400px">
      <el-input v-model="editName" placeholder="修改任务名称" />
      <template #footer>
        <el-button @click="editVisible = false">取消</el-button>
        <el-button type="primary" @click="saveEdit">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

// 任务列表数据
const taskList = ref([
  { id: 1, name: 'HTML', done: true },
  { id: 2, name: 'CSS', done: false },
  { id: 3, name: 'JS', done: false },
  { id: 4, name: 'VUE', done: false },
  { id: 5, name: 'JAVESE', done: false },
  { id: 6, name: 'MYSQL', done: false }
])

const newTask = ref('')
let nextId = 7
const filter = ref('all')

const editVisible = ref(false)
const editName = ref('')
const editId = ref(null)

const filteredList = computed(() => {
  if (filter.value === 'active') {
    return taskList.value.filter(item => !item.done)
  }
  if (filter.value === 'done') {
    return taskList.value.filter(item => item.done)
  }
  return taskList.value
})

const addTask = () => {
  if (!newTask.value.trim()) {
    ElMessage.warning('任务名称不能为空')
    return
  }
  taskList.value.push({
    id: nextId++,
    name: newTask.value.trim(),
    done: false
  })
  newTask.value = ''
  ElMessage.success('添加成功')
}

const deleteTask = (id) => {
  ElMessageBox.confirm('确定删除这条任务吗？', '提示', {
    type: 'warning'
  }).then(() => {
    taskList.value = taskList.value.filter(item => item.id !== id)
    ElMessage.success('删除成功')
  }).catch(() => {})
}

const toggleDone = (row) => {
  ElMessage.success(row.done ? '已标记完成' : '已取消完成')
}

const openEdit = (row) => {
  editId.value = row.id
  editName.value = row.name
  editVisible.value = true
}

const saveEdit = () => {
  if (!editName.value.trim()) {
    ElMessage.warning('任务名称不能为空')
    return
  }
  const target = taskList.value.find(item => item.id === editId.value)
  if (target) {
    target.name = editName.value.trim()
  }
  editVisible.value = false
  ElMessage.success('修改成功')
}
</script>
