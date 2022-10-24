package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findById(int id) {
        Optional<Student> entity = studentRepository.findById(id);
        return entity.get();
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student){
        studentRepository.save(student);
    }
}
