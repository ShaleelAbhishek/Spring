package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Allocation;
import repository.AllocationRepository;

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