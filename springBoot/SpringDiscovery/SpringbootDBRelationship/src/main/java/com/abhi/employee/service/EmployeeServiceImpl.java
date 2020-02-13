package com.abhi.employee.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abhi.employee.model.Allocation;
import com.abhi.employee.model.Employee;
import com.abhi.employee.model.Telephone;
import com.abhi.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;


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
        return null;


    }

    public List<Allocation> fetchAllocation() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Allocation[]> result = restTemplate.getForEntity("http://localhost:8081/services/allocation", Allocation[].class);

        Allocation[] resultBody = result.getBody();

        List<Allocation> allocations = new ArrayList<>();

        for (Allocation allocation : resultBody) {
            allocation.setEmployee(this.findById(allocation.getEmpId()));
            allocations.add(allocation);
        }


        return allocations;
    }
}