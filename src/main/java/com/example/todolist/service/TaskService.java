package com.example.todolist.service;

import com.example.todolist.repo.UserRepository;
import org.springframework.stereotype.Service;
import com.example.todolist.model.Task;

import java.util.List;

@Service
public class TaskService {
    private  final UserRepository userRepository;
    public TaskService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Task> findAll() {
        return userRepository.findAll();
    }
    public Task addTask(Task task) {
        return userRepository.save(task);
    }
    public void deleteTask(long id) {
        userRepository.deleteById(id);
    }
    public Task findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public Task updateTask(Task task) {
        return userRepository.save(task);
    }
}
