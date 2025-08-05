package org.example.sb01.repo;

import org.example.sb01.dto.student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public  class  StudentRepo {
    public List<student> getAllStudent(){
     List<student> studentlist=new ArrayList<>();
         student s1 = new student(1, "Ayoush", "delhi", "java fullstack");
         student s2 = new student(2, "yush", "delhi", "java fullstack");
         student s3 = new student(3, "Aush", "bihar", "javafullstack");
         student s4 = new student(4, "Ayoh", "up", "javafullstack");
         student s5 = new student(5, "Ayosh", "harayana", "javafullstack");
         student s6 = new student(6, "Aysh", "bundelkhand", "javafullstack");
         student s7 = new student(7, "Aoush", "delhi", "javafullstack");

         studentlist.add(s1);
       studentlist.add(s2);
       studentlist.add(s3);
       studentlist.add(s4);
       studentlist.add(s5);
       studentlist.add(s6);


        return studentlist;
    }

}
