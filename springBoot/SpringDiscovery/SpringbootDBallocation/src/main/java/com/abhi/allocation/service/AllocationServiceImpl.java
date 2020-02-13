package com.abhi.allocation.service;

import java.util.List;

import com.abhi.allocation.model.Allocation;
import com.abhi.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AllocationServiceImpl implements AllocationService{

    @Autowired
    AllocationRepository allocationRepository;

   public Allocation save(Allocation allocation){
        return allocationRepository.save(allocation);

    }

    @Override
    public List<Allocation> fetchAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public List<Allocation> getAllocationByEmployeeId(Integer id) {
        return allocationRepository.findByEmpId(id);
    }
}