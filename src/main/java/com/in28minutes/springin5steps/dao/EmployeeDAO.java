package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int Id);

    public Employee save(Employee employee);
    void deleteById(int Id);



}
