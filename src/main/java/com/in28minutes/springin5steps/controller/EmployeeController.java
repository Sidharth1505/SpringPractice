package com.in28minutes.springin5steps.controller;

import com.in28minutes.springin5steps.entity.Employee;
import com.in28minutes.springin5steps.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findALl() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee findById(@PathVariable Integer employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee Not Found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee " + employeeId;
    }
}
