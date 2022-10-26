package com.example.demo.controller;

import com.example.demo.controller.Models.Student;
import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SchoolSystemManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner init (StudentRepository studentRepository) {
		return args -> {
			Student student = new Student();

			student.setFirstName("Dillon");
			student.setLastName("Rochford");
			student.setAddress("Dublin");
			student.setEmergencyContactName("Mam");
			student.setEmergencyContactPhoneNumber("999");

			List<Subject> subjects = new ArrayList<>();

			Subject subject = new Subject();
			subject.setTeacherFirstName("John");
			subject.setTeacherLastName("Doe");
			subject.setSubjectCode("MN320");
			subject.setSubjectName("maths");

			Subject subject1 = new Subject();
			subject1.setTeacherFirstName("Jane");
			subject1.setTeacherLastName("Smith");
			subject1.setSubjectCode("MN112");
			subject1.setSubjectName("english");
			subject1.setNoOfStudents(5);

			Subject subject2 = new Subject();
			subject2.setTeacherFirstName("Jane");
			subject2.setTeacherLastName("Smith");
			subject2.setSubjectCode("MN112");
			subject2.setSubjectName("Irish");
			subject2.setNoOfStudents(0);

			subjects.add(subject);
			subjects.add(subject1);
			subjects.add(subject2);

			student.setSubjects(subjects);

			studentRepository.save(student);
		};
	}
}

