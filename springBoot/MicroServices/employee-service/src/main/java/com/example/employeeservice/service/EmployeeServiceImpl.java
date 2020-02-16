package com.example.employeeservice.service;

import com.example.employeeservice.hystrix.AllocationCommand;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.Telephone;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    public Employee save(Employee employee) {

        for (Telephone telephone : employee.getTelephones()) {
            telephone.setEmployee(employee);

        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer employeeId) {
        Optional<Employee> employees = employeeRepository.findById(employeeId);
        if (employees.isPresent())
            return employees.get();
        return new Employee();


    }

    public Employee fetchAllocation(Integer id) {

        Employee employee = this.findById(id);

        AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);

        employee.setAllocations(Arrays.asList(allocationCommand.execute()));

        return employee;
    }
}
