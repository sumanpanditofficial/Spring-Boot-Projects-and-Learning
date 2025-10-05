package com.cruddemo.crud_demo.rest;

import com.cruddemo.crud_demo.Entity.Employee;
import com.cruddemo.crud_demo.service.EmployeeService;
import com.cruddemo.crud_demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebController {

    private EmployeeService employeeServices;

    @Autowired
    public WebController(EmployeeService employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/employee")
    public List<Employee> returnEmployee(){
        return employeeServices.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeServices.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("This id employee doesn't exist: " + employeeId);
        }
        return  theEmployee;
    }

    //adding new
    @PostMapping("/employee/addnew")
    public Employee addNew(@RequestBody Employee theEmployee){

        return employeeServices.save(theEmployee);

    }
    //updating
    @PutMapping("/employee/update")
    public Employee newUpdatedEmployee(@RequestBody Employee theEmployee){
        return employeeServices.save(theEmployee);
    }

    //deleting
    @DeleteMapping("employee/delete/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){

    employeeServices.delete(employeeId);

    }
}
