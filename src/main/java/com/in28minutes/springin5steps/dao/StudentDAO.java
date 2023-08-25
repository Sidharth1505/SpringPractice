package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student student);

    void saveMultiple(List<Student> students);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
