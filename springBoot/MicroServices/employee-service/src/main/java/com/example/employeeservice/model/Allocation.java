package com.example.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Allocation {

    private Integer id;
    private String startDate;
    private String endDate;
    private String projectCode;
    @JsonIgnore
    private Integer empId;

}
