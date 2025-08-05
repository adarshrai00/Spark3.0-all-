package org.example.webdemo.dto;

public class Student {

    private int id;
    private String name;
    private String Add;
    private String Course;

    public Student(int id, String name, String add, String course) {
        this.id = id;
        this.name = name;
        Add = add;
        Course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Add='" + Add + '\'' +
                ", Course='" + Course + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
