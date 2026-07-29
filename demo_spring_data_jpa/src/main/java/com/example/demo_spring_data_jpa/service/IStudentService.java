package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    List<Student> search(String name);
    Page<Student> search1(String name, Pageable pageable);
    Student findById(int id);
    boolean add(Student student);

}
