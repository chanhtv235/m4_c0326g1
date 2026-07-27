package com.example.demo_thymeleaf.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
//@Table(name = "sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(columnDefinition ="TEXT" )
    private String name;
    private boolean gender;

    public Student() {
    }

    public Student(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
