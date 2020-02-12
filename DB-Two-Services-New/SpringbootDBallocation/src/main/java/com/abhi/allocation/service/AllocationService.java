package com.abhi.allocation.service;

import java.util.List;

import com.abhi.allocation.model.Allocation;


public interface AllocationService {

	Allocation save(Allocation allocation);

	List<Allocation> fetchAllAllocations();

	List<Allocation> getAllocationByEmployeeId(Integer id);

}