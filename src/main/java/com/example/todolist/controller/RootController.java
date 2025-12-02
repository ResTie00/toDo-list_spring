package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String redirectToTasks() {
        return "redirect:/tasks/view";
    }
}
