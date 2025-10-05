package com.cruddemo.crud_demo.dao;

import com.cruddemo.crud_demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
