package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping
    public Result<List<Task>> getList(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String title) {
        return Result.success(taskService.findAll(status, title));
    }

    @GetMapping("/search")
    public Result<List<Task>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String direction) {
        return Result.success(taskService.search(name, direction));
    }

    @GetMapping("/{id}")
    public Result<Task> getById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        if (task == null) {
            return Result.fail("没有找到该用户");
        }
        return Result.success(task);
    }

    @PostMapping
    public Result<Task> add(@RequestBody Task task) {
        if (taskService.saveTask(task)) {
            return Result.success(task);
        }
        return Result.fail("任务新增失败");
    }

    @PutMapping("/{id}")
    public Result<Void> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        if (taskService.modify(task)) {
            return Result.success();
        }
        return Result.fail("没有找到该任务，修改失败");
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteTask(@PathVariable Long id) {
        if (taskService.remove(id)) {
            return Result.success();
        }
        return Result.fail("找不到任务，删除失败");
    }
}
