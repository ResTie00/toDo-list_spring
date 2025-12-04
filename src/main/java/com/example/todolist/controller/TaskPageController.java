package com.example.todolist.controller;

import com.example.todolist.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.service.TaskService;


@Controller
@RequestMapping("/tasks")
public class TaskPageController {

    private final TaskService taskService;

    public TaskPageController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Страница со списком задач
    @GetMapping("/view")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks"; // ищем tasks.html
    }

    // Добавление новой задачи
    @PostMapping("/add")
    public String addTask(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String priority) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setStatus(false); // по умолчанию не выполнена
        taskService.addTask(task);
        return "redirect:/tasks/view";
    }
    @PostMapping("/delete/{id}")
    public  String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/view";
    }

    // Переключение статуса задачи (выполнена/не выполнена)
    @PostMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable long id) {
        Task task = taskService.findById(id);
        if (task != null) {
            task.setStatus(!task.isStatus());
            taskService.updateTask(task);
        }
        return "redirect:/tasks/view";
    }

}
