package com.abhi.allocation.repository;

import java.util.List;

import com.abhi.allocation.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

    List<Allocation> findByEmpId(Integer empId);
}
