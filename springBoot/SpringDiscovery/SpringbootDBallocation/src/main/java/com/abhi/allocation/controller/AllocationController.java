package com.abhi.allocation.controller;

import java.util.List;

import com.abhi.allocation.model.Allocation;
import com.abhi.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/services")

public class AllocationController {


    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation) {

        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public List<Allocation> findAll() {
        return allocationService.fetchAllAllocations();
    }

    @RequestMapping(value = "allocation/findByEmployeeId/{id}", method = RequestMethod.GET)
    public List<Allocation> getAllocationByEmployeeId(@PathVariable Integer id) {
        return allocationService.getAllocationByEmployeeId(id);
    }
}
