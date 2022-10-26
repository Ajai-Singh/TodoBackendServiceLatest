package com.example.demo.controller.Services;

import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.CustomSubjectRepo;
import com.example.demo.controller.Repos.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CustomSubjectRepo customSubjectRepo;

    public String save(Subject subject) {
        if(subject.getSubjectName().equalsIgnoreCase(findByClassName(subject.getSubjectName()).getSubjectName())) {
            return "Subject already exists!";
        } else {
            subjectRepository.save(subject);
            return "Subject created, id: " + subject.getSubjectID();
        }
    }

    public void saveNew(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject findById(int id) {
        Optional<Subject> entity = subjectRepository.findById(id);
        return entity.get();
    }

    public Subject findByClassName(String className) {
        return customSubjectRepo.findSubjectByClassName(className);
    }
}
