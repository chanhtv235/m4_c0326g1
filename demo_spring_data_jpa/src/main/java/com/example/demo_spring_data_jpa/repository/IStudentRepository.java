package com.example.demo_spring_data_jpa.repository;

import com.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
     // method name
    Page<Student> findStudentByNameContaining(String name, Pageable pageable);
    @Query(value = "select * from student where name like concat('%',:searchName,'%')",nativeQuery = true)
    List<Student> searchByName(@Param("searchName") String name);
    // DTO projection
    // interface projection

}
