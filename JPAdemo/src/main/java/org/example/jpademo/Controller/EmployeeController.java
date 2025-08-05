package org.example.jpademo.Controller;


import org.example.jpademo.Repo.EmployeeRepo;
import org.example.jpademo.Service.EmployeeService;
import org.example.jpademo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")


public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
    return  employeeService.getAllEmployees();


     }
     public   void create
}
