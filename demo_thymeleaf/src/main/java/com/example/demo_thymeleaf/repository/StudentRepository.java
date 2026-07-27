package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentQuery = entityManager.createQuery("from Student", Student.class);
        return studentQuery.getResultList();
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try {
            entityManager.persist(student);
            return true;
        }catch (Exception e){
            System.out.println("lỗi");
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
}
