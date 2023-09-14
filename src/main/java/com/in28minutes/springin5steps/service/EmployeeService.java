package com.in28minutes.springin5steps.service;

import com.in28minutes.springin5steps.dao.EmployeeDAO;
import com.in28minutes.springin5steps.dao.EmployeeRepository;
import com.in28minutes.springin5steps.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
//    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int Id) {
        Optional<Employee> employee =  employeeRepository.findById(Id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee Not Found");
        }
    }

//    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
//    @Transactional
    public void deleteById(int Id) {
        employeeRepository.deleteById(Id);
    }
}
