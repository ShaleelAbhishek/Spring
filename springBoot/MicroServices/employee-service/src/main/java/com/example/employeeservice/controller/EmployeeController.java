package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/services")

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }


    @RequestMapping("/employee/allocation/{id}")
    public Employee getFetchAllocation(@PathVariable Integer id) {

        return employeeService.fetchAllocation(id);
    }

}
