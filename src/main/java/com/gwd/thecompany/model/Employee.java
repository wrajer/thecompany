package com.gwd.thecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //konstruktory dwa tworzone przez Lombok
@AllArgsConstructor
@Data //załatwia nam gett sett to String  hashcode quels
@Builder
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String position;
    private Integer superiorId;


    private Float salary;

    @ManyToOne
    private Office office;

    private String adress;

    //todo make new Object Adress which can be use by office and person
    //todo add hire date etc


    public Employee(String name, String surname, String position, Integer superiorId,  Float salary, String adress) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.superiorId = superiorId;
        this.salary = salary;
        //this.office = office;
        this.adress = adress;
    }
}
