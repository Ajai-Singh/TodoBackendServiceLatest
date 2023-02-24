package com.example.demo.controller.Repos;

import com.example.demo.controller.Models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
