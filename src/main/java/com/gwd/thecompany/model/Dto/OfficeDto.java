package com.gwd.thecompany.model.Dto;

import com.gwd.thecompany.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OfficeDto {

    private Long id;
    private String name;
    private Long noOfDesks;
    private Long noPeople;
    private String adress;
    private Float costPerMonth;

    private List<Employee> employeesList = new ArrayList<>();
/*    private List<String> employeesList = new ArrayList<>();*/

}
