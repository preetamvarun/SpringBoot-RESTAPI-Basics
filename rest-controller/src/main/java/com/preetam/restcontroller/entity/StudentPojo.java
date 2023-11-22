package com.preetam.restcontroller.entity;

public class StudentPojo {
    private String studentFirstName, studentLastName;

    // define a default constructor
    public StudentPojo(){

    }
    // Initialize our private fields
    public StudentPojo(String firstName, String lastName){
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
    }
    // define setters
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
    // define getters
    public String getStudentFirstName() {
        return studentFirstName;
    }
    public String getStudentLastName() {
        return studentLastName;
    }
}
