package org.example.jpademo.Service;


import org.example.jpademo.Repo.EmployeeRepo;
import org.example.jpademo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
     @Autowired
    EmployeeRepo employeeRepo;
     public List<Employee> getAllEmployees() {
         List<Employee> listEmp=employeeRepo.findAll();
         System.out.println(listEmp);
         return listEmp;

     }

}
