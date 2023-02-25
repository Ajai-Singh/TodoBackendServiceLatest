package com.example.demo.controller;

import com.example.demo.controller.Models.Todo;
import com.example.demo.controller.Service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Controller implements ControllerInterface {

    @Autowired
    private TodoServiceImpl todoService;

    @Override
    public List<Todo> getAllTodos(String userName) {
        return todoService.getTodos(userName);
    }

    @Override
    public void createTodo(Todo todo) {
        todoService.saveTodo(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoService.updateTodo(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoService.deleteTodo(todo);
    }

    @Override
    public void deleteTodoById(int id) {
        todoService.deleteById(id);
    }

    @Override
    public Todo getTodo(int id) {
        return todoService.getTodo(id);
    }

    @Override
    public String helloWorldTest() {
        return "ajai";
    }
}
