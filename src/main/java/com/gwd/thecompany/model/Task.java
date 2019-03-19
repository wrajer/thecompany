package com.gwd.thecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor //konstruktory dwa tworzone przez Lombok
@AllArgsConstructor
@Data //załatwia nam gett sett to String  hashcode quels
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String priority;

    @ManyToMany (mappedBy="tasks")
    private List<Employee> taskEmpList = new ArrayList<>();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Start_at")
    private Date start_at= new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "End_at")
    private Date end_at= new Date();


    //todo startdate enddate, office
    //todo add person responsible for this office, add Office



}
