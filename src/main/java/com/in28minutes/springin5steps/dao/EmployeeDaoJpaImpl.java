package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    @Autowired
    private final EntityManager entityManager;

    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee findById(int Id) {
        return entityManager.find(Employee.class, Id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int Id) {
        Employee  employee = entityManager.find(Employee.class, Id);
        entityManager.remove(employee);

    }
}
