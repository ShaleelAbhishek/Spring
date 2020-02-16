package com.example.allocationservice.service;

import com.example.allocationservice.model.Allocation;

import java.util.List;


public interface AllocationService {
    Allocation save(Allocation allocation);

    List<Allocation> fetchAllAllocations();

    List<Allocation> getAllocationByEmployeeId(Integer id);
}
