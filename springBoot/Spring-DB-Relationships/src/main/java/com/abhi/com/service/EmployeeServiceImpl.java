package com.abhi.com.service;

import com.abhi.com.model.Employee;
import com.abhi.com.model.Address;
import com.abhi.com.model.Project;
import com.abhi.com.model.Telephone;

import com.abhi.com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shaleel on 2/11/2020.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
}
