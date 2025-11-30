package com.example.todolist.controller;

import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.model.Task;

import java.util.List;

@RestController
@RequestMapping("/tasks")
class TaskController {
    private TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }
    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }




}
