package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Override
    public List<Task> findAll(String status, String title) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(title), Task::getTitle, title)
                .eq(StringUtils.hasText(status), Task::getStatus, status)
                .orderByAsc(Task::getId);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Task findTaskById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Task> search(String name, String direction) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(name), Task::getTitle, name)
                .like(StringUtils.hasText(direction), Task::getStatus, direction)
                .orderByAsc(Task::getId);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public boolean saveTask(Task task) {
        return baseMapper.insert(task) > 0;
    }

    @Override
    public boolean modify(Task task) {
        if (baseMapper.selectById(task.getId()) == null) {
            return false;
        }
        return baseMapper.updateById(task) > 0;
    }

    @Override
    public boolean remove(Long id) {
        if (baseMapper.selectById(id) == null) {
            return false;
        }
        return baseMapper.deleteById(id) > 0;
    }
}
