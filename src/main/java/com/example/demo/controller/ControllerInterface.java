package com.example.demo.controller;

import com.example.demo.controller.Models.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface ControllerInterface {
    @GetMapping("/todos")
    List<Todo> getAllTodos();

    @PostMapping("createTodo")
    void createTodo(@RequestBody Todo todo);

    @PutMapping("update")
    void updateTodo(@RequestBody Todo todo);

    @DeleteMapping("/delete")
    void deleteTodo(@RequestBody Todo todo);

    @GetMapping("/helloWorld")
    String helloWorldTest();
}
