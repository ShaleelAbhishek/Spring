package com.abhi.employee.example1.employeeservice.repository;

import com.abhi.employee.example1.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shaleel on 2/9/2020.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {
    //Employee save(Employee employee);
}
