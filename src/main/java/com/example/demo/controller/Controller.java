package com.example.demo.controller;

import com.example.demo.controller.Models.Student;
import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Services.StudentService;
import com.example.demo.controller.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

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
        return studentService.findById(id);
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

    @GetMapping("viewAllStudentsByClassName/{className}")
    public List<Student> viewAllStudentsByClassName(@PathVariable String className) {
        return studentService.getAllStudentsByClassName(className);
    }

    @PutMapping("joinClass/{id}")
    public String joinClass(@PathVariable() Integer id, @RequestBody Subject subject) {
        Student student = studentService.findById(id);

        student.setId(id);

        if(student.getSubjects().size() >= 2) {
            return student.getFirstName() + " " +student.getLastName() + " , timetable is full";
        } else if(subject.getNoOfStudents() >= 5) {
            return "Class is full sorry!";
        } else {
            subject.setSubjectID(subject.getSubjectID());
            subject.setNoOfStudents(subject.getNoOfStudents() + 1);

            subjectService.save(subject);

            student.getSubjects().add(subject);

            studentService.save(student);
            return student.getFirstName() + " " +student.getLastName() + " has joined " + subject.getSubjectName();
        }

    }
}
