package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
