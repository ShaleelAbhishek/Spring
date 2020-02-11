package service;

import java.util.List;

import model.Allocation;

public interface AllocationService {

	Allocation save(Allocation allocation);

	List<Allocation> fetchAllAllocations();

	List<Allocation> getAllocationByEmployeeId(Integer id);

}