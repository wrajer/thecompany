package com.gwd.thecompany.model.Dto;

import com.gwd.thecompany.model.Employee;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

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
