package org.example.sb01.service;

import org.example.sb01.dto.student;
import org.example.sb01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class studentservice {
    @Autowired
    StudentRepo studentrepo;

    public List<student> getAllStudent()
      {
          List<student> studentlist = new ArrayList<student>();
          studentlist.add(1, "Ayoush", "delhi", "java fullstack");
          return studentlist;
      }




}
