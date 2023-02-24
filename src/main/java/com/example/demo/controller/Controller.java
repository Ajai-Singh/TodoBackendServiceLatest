package com.example.demo.controller;

import com.example.demo.controller.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {

    @Autowired
    private TodoService todoService;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }
}
