package com.example.demo.controller.Services;

import com.example.demo.controller.Repos.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository subjectRepository;

}
