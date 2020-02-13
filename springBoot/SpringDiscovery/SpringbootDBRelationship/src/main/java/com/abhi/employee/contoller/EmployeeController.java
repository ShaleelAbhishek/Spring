package com.abhi.employee.contoller;

import java.util.List;

import com.abhi.employee.model.Allocation;
import com.abhi.employee.model.Employee;
import com.abhi.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




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

    @RequestMapping("/employee/allocation")
    public List<Allocation> getEmployeesAllocation() {
        return employeeService.fetchAllocation();
    }

}