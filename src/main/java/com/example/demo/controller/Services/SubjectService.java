package com.example.demo.controller.Services;

import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.CustomSubjectRepo;
import com.example.demo.controller.Repos.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CustomSubjectRepo customSubjectRepo;

    public String save(Subject subject) {
        subjectRepository.save(subject);
        return "Subject saved, id: " + subject.getSubjectID();
    }

    public Subject findById(int id) {
        Optional<Subject> entity = subjectRepository.findById(id);
        return entity.get();
    }

    public Subject findByClassName(String className) {
        return customSubjectRepo.findSubjectByClassName(className);
    }

    public List<Subject> getAllSubjectsWithSpace() {
        List<Subject> subjects = (List<Subject>) subjectRepository.findAll();
        subjects.removeIf(subject -> subject.getNoOfStudents() > 2);
        return subjects;
    }

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectRepository.findAll();
    }
}
