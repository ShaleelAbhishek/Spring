package service;

import java.util.List;

import model.Allocation;
import model.Employee;


public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAllEmployees();

	Employee findById(Integer employeeId);

	List<Allocation> fetchAllocation();

}