package com.example.demo_spring_mvc.repository;

import com.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
}
