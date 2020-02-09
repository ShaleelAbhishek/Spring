package com.abhi.employee.example1.employeeservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Employee {



    @Id
    private int id;
    private String name;
    private int marks;

    public Employee(int id, String name, int mark){
        this.id=id;
        this.name=name;
        this.marks=mark;
    }

    public Employee(){

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

    public int getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
