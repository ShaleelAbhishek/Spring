package com.abhi.employee.service;

import com.abhi.employee.model.Allocation;
import com.abhi.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee findById(Integer employeeId);

    List<Allocation> fetchAllocation();
}
