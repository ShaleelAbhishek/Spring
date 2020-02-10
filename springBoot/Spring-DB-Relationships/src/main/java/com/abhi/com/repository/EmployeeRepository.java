package com.abhi.com.repository;

import com.abhi.com.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shaleel on 2/11/2020.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
