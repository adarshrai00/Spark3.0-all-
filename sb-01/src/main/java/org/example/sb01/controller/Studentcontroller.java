package org.example.sb01.controller;

import org.example.sb01.dto.student;
import org.example.sb01.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Studentcontroller {


    @Autowired
    private studentservice service;

    @GetMapping("/getAll")
       public List<student> getAllStudent()
    {
       return service.getAllStudent();
    }
}
