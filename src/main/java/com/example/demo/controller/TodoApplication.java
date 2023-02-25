package com.example.demo.controller;

import com.example.demo.controller.Models.Todo;
import com.example.demo.controller.Repos.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TodoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	CommandLineRunner init (TodoRepository todoRepository) {
		return args -> {
			Todo todo = new Todo("maths", true, new Date(), "test");
			Todo todo1 = new Todo("english", false, new Date(), "test");
			Todo todo2 = new Todo("french", false, new Date(), "chloe");
			todoRepository.save(todo);
			todoRepository.save(todo1);
			todoRepository.save(todo2);
		};
	}
}

