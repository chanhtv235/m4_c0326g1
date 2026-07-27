package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.entity.Student;
import com.example.demo_thymeleaf.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository implements IStudentRepository{
//    private static List<Student> studentList = new ArrayList<>();
//    static {
//        studentList.add(new Student(1,"chánh1",true));
//        studentList.add(new Student(2,"chánh1",true));
//        studentList.add(new Student(3,"chánh1",true));
//    }

    @Override
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Query<Student> type = session.createQuery("FROM Student", Student.class);
//        Query<Student> type = session.createNativeQuery("select * from student", Student.class);
        return type.getResultList();
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.persist(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("lỗi thêm mới");
        }

        return false;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Student.class,id);
    }
}
