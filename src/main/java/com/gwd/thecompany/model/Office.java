package com.gwd.thecompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_name", unique = true, nullable = false)
    private String name;

    @Column(name = "office_no_of_desks")
    private Long noOfDesks;

    @Column(name = "office_adress")
    private String adress;

    @Column(name = "office_cost_per_month")
    private Float costPerMonth;

    //todo sprawdz czy to jest dobre połączneie, czy jak uunę jedno to zostaje drugi etylko z NULL
    @JsonIgnore
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    //tu test bo jest to nawiązanie, nazwa klucza obcego po drugiej stronie
    private List<Employee> employeesList = new ArrayList<>();


    //todo make new Object Adress which can be use by office and person
    //todo add person responsible for this office, add Office

public void addEmpToList (Employee employee) {
    this.employeesList.add(employee);
}



/*    public Office(Long id, String name, Integer noOfDesks, String adress, Float costPerMonth, List<Employee> employeesList) {
        this.id = id;
        this.name = name;
        this.noOfDesks = noOfDesks;
        this.adress = adress;
        this.costPerMonth = costPerMonth/noOfDesks;
        this.employeesList = employeesList;
    }*/
}
