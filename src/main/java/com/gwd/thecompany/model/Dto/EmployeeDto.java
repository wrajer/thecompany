package com.gwd.thecompany.model.Dto;

import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class EmployeeDto {



   // private Long id;
     private String name;
    private String surname;
     private String password;
    private String email;
    private String login;
    private String access;
    private String position;
    private Integer superiorId;
    private Float salary;
    private Date start_at= new Date();
    private Office office;
    private String adress;

    private List<String> tasks = new ArrayList<>();



}

