package com.example.demo.controller.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Table(name = "subjects")
@JsonSerialize
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @JsonProperty
    private int subjectID;

    @JsonProperty
    @Column(name = "subjectName")
    private String subjectName;

    @JsonProperty
    @Column(name = "teachFirstName")
    private String teacherFirstName;

    @JsonProperty
    @Column(name = "teachLastName")
    private String teacherLastName;

    @JsonProperty
    @Column(name = "subjectCode")
    private String subjectCode;

    @Column(name = "noOfStudents")
    private int noOfStudents;

    public Subject() {

    }

    public Subject(String subjectName, String teacherFirstName, String teacherLastName, String subjectCode, int noOfStudents) {
        this.subjectName = subjectName;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.subjectCode = subjectCode;
        this.noOfStudents = noOfStudents;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID=" + subjectID +
                ", subjectName='" + subjectName + '\'' +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
