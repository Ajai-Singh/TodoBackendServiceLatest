package com.example.demo.controller.DAOs;

import com.example.demo.controller.Models.Student;
import com.example.demo.controller.Repos.CustomStudentRepo;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements CustomStudentRepo {

    @Override
    public void removeStudentFromModules(Student student) {

    }
}
