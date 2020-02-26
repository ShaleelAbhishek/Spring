package com.abhi.employee.example1.employeeservice.service;

import com.abhi.employee.example1.employeeservice.model.Employee;
import com.abhi.employee.example1.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.abhi.employee.example1.employeeservice.controller.EmployeeController;
/**
 * Created by Shaleel on 2/9/2020.
 */
@Service
public class EmployeeServiceImpl implements  EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public Employee save(Employee employee){

        return employeeRepository.save(employee);
    }
}