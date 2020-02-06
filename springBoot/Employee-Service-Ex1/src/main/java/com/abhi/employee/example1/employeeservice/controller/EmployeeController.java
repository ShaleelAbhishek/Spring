package com.abhi.employee.example1.employeeservice.controller;

import com.abhi.employee.example1.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/hello")
@XmlRootElement
public class EmployeeController {

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        return Employee.getAllEmployees();
    }

}
