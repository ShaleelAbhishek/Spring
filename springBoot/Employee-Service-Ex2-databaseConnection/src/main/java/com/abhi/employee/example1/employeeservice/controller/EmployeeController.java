package com.abhi.employee.example1.employeeservice.controller;

import com.abhi.employee.example1.employeeservice.model.Employee;
import com.abhi.employee.example1.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/hello")
@XmlRootElement
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public void greeting(){
        System.out.println("Hello");
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        return new Employee(001,"abhi",75);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
}
