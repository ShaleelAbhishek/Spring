package com.abhi.com.controller;

import com.abhi.com.model.Address;
import com.abhi.com.model.Employee;
import com.abhi.com.model.Project;
import com.abhi.com.model.Telephone;
import com.abhi.com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaleel on 2/11/2020.
 */
@RestController
@RequestMapping("/hello")
@XmlRootElement
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee" , method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value="/fetch")
    Employee TestFetch(){
        List<Telephone> telephones = new ArrayList<>();
        //List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        Address address = new Address();
        address.setId(1);
        address.setCity("Colombo");

        Project project = new Project();
        project.setId(1);
        project.setProjectName("ProjectName");
        //project.setEmployees(employees);
        projects.add(project);

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("ABC");
        employee.setAddress(address);
        employee.setTelephones(telephones);
        employee.setProjects(projects);
        //employees.add(employee);

        Telephone telephone = new Telephone();
        telephone.setId(1);
        telephone.setTelephoneNumber("45435345");
        telephone.setEmployee(employee);
        telephones.add(telephone);

        return employee;
    }

    @RequestMapping(value = "/post" , method = RequestMethod.POST)
    Employee saveEmployee(@RequestBody Employee employee){

        for(Telephone telephone: employee.getTelephones()) {
            telephone.setEmployee(employee);
        }

        return employeeService.save(employee);
    }

}
