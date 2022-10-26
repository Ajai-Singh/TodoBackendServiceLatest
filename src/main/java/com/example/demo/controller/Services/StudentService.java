package com.example.demo.controller.Services;

import com.example.demo.controller.Models.Student;
import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.CustomStudentRepo;
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

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CustomStudentRepo customStudentRepo;

    public Student findById(int id) {
        Optional<Student> entity = studentRepository.findById(id);
        return entity.get();
    }

    public void deleteById(int id) {
        //TODO
        Student student = findById(id);
        Subject subject;
        for(int i = 0; i < student.getSubjects().size(); i++) {
            subject = student.getSubjects().get(i);

            int numberOfStudents = subject.getNoOfStudents();
            subject.setNoOfStudents(numberOfStudents--);

            subjectService.saveNew(subject);
        }

        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudentsByClassName(String className) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentRepository.findAll()) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getSubjectName().equalsIgnoreCase(className)) {
                    students.add(student);
                }
            }
        }

        return students;
    }

    public String joinClass(String className, Student student) {
        //TODO
        Subject subject = subjectService.findByClassName(className);
        if(subject == null) {
            return "Class not found please try again!";
        }

        for (int i = 0; i < student.getSubjects().size(); i++) {
            if (student.getSubjects().get(i).getSubjectName().equalsIgnoreCase(className)) {
                return "Student is already enrolled in this class!";
            }
        }

        if (student.getSubjects().size() >= 2) {
            return student.getFirstName() + " " + student.getLastName() + " , timetable is full";
        } else if (subject.getNoOfStudents() >= 5) {
            return "Class is full sorry!";
        } else {
            subject.setNoOfStudents(subject.getNoOfStudents() + 1);

            student.getSubjects().add(subject);

            save(student);
            subjectService.save(subject);
            return student.getFirstName() + " " + student.getLastName() + " has joined " + subject.getSubjectName();
        }
    }
}