package com.gwd.thecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @NotNull
    //    @Size(max = 100)
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_surname")
    private String surname;
    @Column(name = "emp_email")
    private String email;
    @Column(name = "emp_login")
    private String login;
    @Column(name = "emp_position")
    private String position;
    @Column(name = "emp_sup_id")
    private Integer superiorId;

    @Column(name = "emp_salary")
    private Float salary;

  //  @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "epm_hire_data")
    private Date start_at= new Date();

    //todo check if correct
    @ManyToOne
    private Office office;

    @Column(name = "emp_adress")
    private String adress;

    //    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "fk_tasks")

    //od łukasza
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable (
//            name="emp_task",//stworzy mi się nowa tableta
//            joinColumns = @JoinColumn(name = "emp_id"),
//            inverseJoinColumns = @JoinColumn(name="task_id"))
    @ManyToMany
    private List<Task> tasks = new ArrayList<>();

    //todo make new Object Adress which can be use by office and person
    //todo add hire date etc


}
