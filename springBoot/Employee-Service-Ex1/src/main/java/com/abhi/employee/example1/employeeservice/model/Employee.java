package com.abhi.employee.example1.employeeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int marks;

    public Employee(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }


    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("kamal",65));
        employeeList.add(new Employee("vimal",55));
        employeeList.add(new Employee("nimal",45));
        employeeList.add(new Employee("bimal",75));
        employeeList.add(new Employee("sunimal",85));

        return employeeList;
    }

}
