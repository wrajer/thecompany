package com.gwd.thecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //konstruktory dwa tworzone przez Lombok
@AllArgsConstructor
@Data //załatwia nam gett sett to String  hashcode quels
@Builder
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;
    private String surname;
    private String position;
    private Integer superiorId;


    private Float salary;

    //todo check if correct
    @ManyToOne
    private Office office;

    private String adress;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "fk_tasks")
    @ManyToMany
    private List<Task> tasks = new ArrayList<>();

    //todo make new Object Adress which can be use by office and person
    //todo add hire date etc




    public Employee(String name, String surname, String position, Integer superiorId,  Float salary, String adress) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.superiorId = superiorId;
        this.salary = salary;

        this.adress = adress;
    }
}
