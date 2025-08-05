package org.example.webdemo.Controller;


import org.example.webdemo.Service.StudentService;
import org.example.webdemo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Student")
 class StudentController {

    @Autowired
     StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return  studentService.getAllStudents();

    }
    @PostMapping("/save")
    public Student insertData(@RequestBody Student student)
    {
        System.out.println(student);
        studentService.svalue(student);
        return student;
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id) {
        System.out.println("Student id "+id);
        studentService.deleteid(id);


      }
      @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id,student);


      }
    @PatchMapping("/{id}")
    public void setpatc(@PathVariable int id, @RequestBody Map<String,Object> map) {
       studentService.serpatc(id,map);

    }


}
