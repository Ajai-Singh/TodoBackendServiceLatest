package com.example.demo.controller.Services;

import com.example.demo.controller.Models.Student;
import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
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

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudentsByClassName(String className) {
        List<Student> students = new ArrayList<>();

        for(Student student : studentRepository.findAll()) {
            for(Subject subject : student.getSubjects()) {
                if(subject.getSubjectName().equalsIgnoreCase(className)) {
                    students.add(student);
                }
            }
        }

        return students;
    }
}
