package com.example.demo.controller.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "results")
@JsonSerialize
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @JsonProperty
    private int id;

    @Column(name = "averageResult")
    private double averageResult;

    public Result(double averageResult) {
        this.averageResult = averageResult;
    }

    public Result() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAverageResult() {
        return averageResult;
    }

    public void setAverageResult(double averageResult) {
        this.averageResult = averageResult;
    }
}
