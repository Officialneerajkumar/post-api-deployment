package com.example.University.Event.Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity // used to create table in db
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // used to make id as primary key and autoincreament
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String department;
}
