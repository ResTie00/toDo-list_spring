package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

class Login {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
