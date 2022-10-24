package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>("Student record was created successfully, Student id: " + student.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable() Integer id) {
        studentService.deleteById(id);
        return new ResponseEntity<>("Student record was deleted Successfully, Student id: " + id,HttpStatus.OK);
    }

    @GetMapping("/findStudentById/{id}")
    public Student findStudentByd(@PathVariable() Integer id) {
        Student student = studentService.findById(id);
        return student;
    }

    @PutMapping("/updateStudentDetails/{id}")
    public void updateStudentDetails(@RequestBody() Student student, @PathVariable Integer id) {
        student.setId(id);
        studentService.save(student);
    }

    @GetMapping("viewStudentSubjects/{id}")
    public ResponseEntity<String> viewStudentSubjects(@PathVariable() Integer id) {
        return new ResponseEntity<>("Student subjects: " + studentService.findById(id).getSubjects().toString(), HttpStatus.OK);
    }

    @PutMapping("/ModifyStudentSubjects")
    public void modifyStudentSubjects() {

    }
}
