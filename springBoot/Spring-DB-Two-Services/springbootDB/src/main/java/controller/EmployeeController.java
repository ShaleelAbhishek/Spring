package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Allocation;
import model.Employee;
import service.EmployeeService;


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