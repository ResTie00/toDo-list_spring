package com.example.todolist.repo;

import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Task, Long> {
}
