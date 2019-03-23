package com.gwd.thecompany.model.Dto;

import com.gwd.thecompany.model.Employee;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class TaskDto {


    // private Long id;
    private String name;
    private String description;
    private String priority;

    private List<String> taskEmpList = new ArrayList<>();


    private String start_at;
    private String end_at;

/*  private Date start_at = new Date();
  private Date end_at = new Date();*/

}


