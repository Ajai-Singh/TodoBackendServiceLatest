package com.example.demo.controller.Repos;

import com.example.demo.controller.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}