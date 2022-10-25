package com.example.demo.controller.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;

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


}
