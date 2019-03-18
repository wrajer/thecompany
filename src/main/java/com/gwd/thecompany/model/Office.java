package com.gwd.thecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //konstruktory dwa tworzone przez Lombok
@AllArgsConstructor
@Data //załatwia nam gett sett to String  hashcode quels
//@Builder
@Entity
public class Office {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer noOfDesks;
    private String adress;

    @OneToMany(mappedBy ="office", cascade = CascadeType.ALL) //tu test bo jest to nawiązanie, nazwa klucza obcego po drugiej stronie
    private List<Employee> employeesList = new ArrayList<>();

    //todo make new Object Adress which can be use by office and person
    //todo add person responsible for this office, add Office


    public Office(String name, Integer noOfDesks, String adress, List<Employee> employeesList) {
        this.name = name;
        this.noOfDesks = noOfDesks;
        this.adress = adress;
        this.employeesList = employeesList;
    }
}
