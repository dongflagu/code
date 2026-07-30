package com.example.demo.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.example.demo.entity.Task;
import java.util.List;

public interface TaskService extends IService<Task> {
    List<Task> findAll(String status, String title);
    Task findTaskById(Long id);
    List<Task> search(String name, String direction);
    boolean saveTask(Task task);
    boolean modify(Task task);
    boolean remove(Long id);
}
