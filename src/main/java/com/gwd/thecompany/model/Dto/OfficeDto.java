package com.gwd.thecompany.model.Dto;

import com.gwd.thecompany.model.Employee;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OfficeDto {


  //  private Long id; pozostałe elementy jak w Office
    private String name;
    private Integer noOfDesks;
    private String adress;
    private Float costPerMonth;

    private List<String> employeesList = new ArrayList<>();


}
