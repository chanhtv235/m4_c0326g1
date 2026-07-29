package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.entity.Student;
import com.example.demo_spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository ;
    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> search(String name) {
        return studentRepository.searchByName(name);
    }

    @Override
    public Page<Student> search1(String name, Pageable pageable) {
        return studentRepository.findStudentByNameContaining(name,pageable);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.save(student)!=null;
    }
}
