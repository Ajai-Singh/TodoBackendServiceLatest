package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/createPerson")
    public ResponseEntity<Object> createPerson(@RequestBody Person person) {
        personService.save(person);
        return new ResponseEntity<>("Person was created Succesfully", HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<Object> deleteProspect(@PathVariable() Integer id){
        personService.deleteById(id);
        return new ResponseEntity<>("Prospect was deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public Person findByd(@PathVariable() Integer id){
        System.out.println("working" + personService.findById(id).toString());
        return personService.findById(id);
    }
}
