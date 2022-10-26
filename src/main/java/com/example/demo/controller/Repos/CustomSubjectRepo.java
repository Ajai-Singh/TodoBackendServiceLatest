package com.example.demo.controller.Repos;


import com.example.demo.controller.Models.Subject;

public interface CustomSubjectRepo {
    Subject findSubjectByClassName(String className);
}
