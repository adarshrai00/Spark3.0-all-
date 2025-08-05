package org.example.webdemo.Repo;

import org.example.webdemo.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    List<Student> students = new ArrayList<>();

    public  void updateStudent(int id, Student ustudent) {
        for(Student student :students)
        {
            if(student.getId() == id)
            {
                student.setId(ustudent.getId());
                student.setName(ustudent.getName());
                student.setAdd(ustudent.getAdd());
                student.setCourse(ustudent.getCourse());
                break;
            }
        }
    }

    public List<Student> getAllStudents() {


        // Add student objects to the list
        students.add(new Student(1, "John", "Delhi", "Java"));
        students.add(new Student(2, "Ravi", "Mumbai", "Python"));
        students.add(new Student(3, "Anjali", "Bangalore", "C++"));
        students.add(new Student(4, "Priya", "Chennai", "JavaScript"));
        students.add(new Student(5, "Amit", "Kolkata", "Go"));

        // Return the populated list
        return students;
    }

    public void saveval(Student student) {
        students.add(student);

    }

    public void iddel(int id) {

         for(Student student : students) {
             if(student.getId()==id)
             {
                 students.remove(student);
                 break;

             }
         }
    }

    public void serpatc(int id, Map<String, Object> update) {
        for(Student student : students) {
            if(student.getId()==id)
            {
                if(update.containsKey("name"))
                {
                    student.setName((String)update.get("name"));
                }
                if(update.containsKey("Add"))
                {
                    student.setAdd((String)update.get("Add"));

                }
                if(update.containsKey("Course"))
                {
                    student.setCourse((String)update.get("Course"));
                }
            }
        }
    }
}
