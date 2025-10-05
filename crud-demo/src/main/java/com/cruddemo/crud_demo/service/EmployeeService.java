package com.cruddemo.crud_demo.service;

import com.cruddemo.crud_demo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    public void delete(int id);
}
