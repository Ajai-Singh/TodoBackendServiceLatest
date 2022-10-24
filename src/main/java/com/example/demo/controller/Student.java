package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonSerialize
@Table(name = "Students")
public class Student {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",updatable = false, nullable = false)
    private int id;

    @JsonProperty
    @Column(name = "firstName")
    private String firstName;

    @JsonProperty
    @Column(name = "lastName")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @Column(name = "averageResult")
    private double averageResult;

    @Column(name = "address")
    private String address;

    @Column(name = "emergencyContactName")
    private String emergencyContactName;

    @Column(name = "emergencyContactPhoneNumber")
    private String emergencyContactPhoneNumber;


    public Student(String firstName, String lastName, List<Subject> subjects, double averageResult, String address, String emergencyContactName, String emergencyContactPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
        this.averageResult = averageResult;
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public double getAverageResult() {
        return averageResult;
    }

    public void setAverageResult(double averageResult) {
        this.averageResult = averageResult;
    }
}