package org.example.webdemo.Service;


import org.example.webdemo.Repo.StudentRepo;
import org.example.webdemo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
     StudentRepo studentRepo;

    public  void updateStudent(int id, Student student) {
        studentRepo.updateStudent(id,student);
    }

    public void svalue(Student student) {
        studentRepo.saveval(student);

    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }


    public void deleteid(int id) {
        studentRepo.iddel(id);
        System.out.println("hii");
    }

    public void serpatc(int id, Map<String, Object> map) {

        studentRepo.serpatc(id,map);
    }
}

