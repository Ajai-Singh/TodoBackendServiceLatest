package com.example.demo.controller.Service;

import com.example.demo.controller.Models.Todo;
import com.example.demo.controller.Repos.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos(String userName) {
        List<Todo> allTodos = (List<Todo>) todoRepository.findAll();
        return allTodos.stream().filter(todo -> todo.getUserName().equalsIgnoreCase(userName)).collect(Collectors.toList());
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

    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    public Todo getTodo(int id) {
        return todoRepository.findById(id).get();
    }
}
