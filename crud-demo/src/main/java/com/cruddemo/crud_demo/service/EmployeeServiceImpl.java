package com.cruddemo.crud_demo.service;

import com.cruddemo.crud_demo.Entity.Employee;
import com.cruddemo.crud_demo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {  // <-- implement a Service interface, not repository

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();  // just call repo
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);  // handle Optional
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
