package com.example.demo.controller.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;
import java.util.Date;

@Entity
@JsonSerialize
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty
    private int id;

    @Column(name = "description")
    @JsonProperty
    private String description;

    @Column(name = "status")
    @JsonProperty
    private boolean status;

    @Column(name = "completionDate")
    @JsonProperty
    private Date completionDate;

    @Column(name = "userName")
    @JsonProperty
    private String userName;

    public Todo() {

    }

    public Todo(String description, boolean status, Date completionDate, String userName) {
        this.description = description;
        this.status = status;
        this.completionDate = completionDate;
        this.userName = userName;
    }

    public Todo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", completionDate=" + completionDate +
                ", userName='" + userName + '\'' +
                '}';
    }
}
