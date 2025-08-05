package org.example.sb01.dto;

public class student {

    private String address ;
    private String Course;
    public student(int id, String name, String address, String course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.Course = course;
    }

    int id;
    private String name ;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", Course=" + Course +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }


}
