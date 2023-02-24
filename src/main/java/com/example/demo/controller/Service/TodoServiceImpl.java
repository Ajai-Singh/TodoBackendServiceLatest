package com.example.demo.controller.Service;

import com.example.demo.controller.Models.Todo;
import com.example.demo.controller.Repos.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoServiceImpl {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
