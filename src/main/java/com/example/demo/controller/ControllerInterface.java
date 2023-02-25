package com.example.demo.controller;

import com.example.demo.controller.Models.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface ControllerInterface {
    @GetMapping("/todos/{userName}")
    List<Todo> getAllTodos(@PathVariable String userName);

    @PostMapping("/createTodo")
    void createTodo(@RequestBody Todo todo);

    @PutMapping("/update")
    void updateTodo(@RequestBody Todo todo);

    @DeleteMapping("/delete")
    void deleteTodo(@RequestBody Todo todo);

    @DeleteMapping("/deleteById/{id}")
    void deleteTodoById(@PathVariable int id);

    @GetMapping("/todo/{id}")
    Todo getTodo(@PathVariable int id);

    @GetMapping("/helloWorld")
    String helloWorldTest();
}
