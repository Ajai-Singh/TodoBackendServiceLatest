package com.example.demo.controller;

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
	CommandLineRunner init (StudentRepository studentRepository){
		return args -> {
			Student student = new Student();

			student.setFirstName("Dillon");
			student.setLastName("Rochford");

			List<Subject> subjects = new ArrayList<>();

			Subject subject = new Subject();
			subject.setTeacherFirstName("John");
			subject.setTeacherLastName("Doe");
			subject.setSubjectCode("MN320");
			subject.setSubjectName("Marketing");

			Subject subject1 = new Subject();
			subject1.setTeacherFirstName("Jane");
			subject1.setTeacherLastName("Smith");
			subject1.setSubjectCode("MN112");
			subject1.setSubjectName("Maths");

			subjects.add(subject);
			subjects.add(subject1);

			student.setSubjects(subjects);

			studentRepository.save(student);
		};
	}
}

