package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person findById(int id) {
        Optional<Person> entity = personRepo.findById(id);
        return entity.get();
    }

    public void deleteById(int id) {
        personRepo.deleteById(id);
    }

    public void save(Person person){
        personRepo.save(person);
    }
}
