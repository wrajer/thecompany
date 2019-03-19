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
@Builder
@Entity
@Table (name="offices")
public class Office {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_name", unique = true, nullable = false)
    private String name;

    @Column(name = "office_no_of_desks")
    private Integer noOfDesks;

    @Column(name = "office_adress")
    private String adress;

    @Column(name = "office_cost_per_month")
    private Float costPerMonth;

    //todo sprawdz czy to jest dobre połączneie
    @OneToMany(mappedBy ="office", cascade = CascadeType.ALL) //tu test bo jest to nawiązanie, nazwa klucza obcego po drugiej stronie
    private List<Employee> employeesList = new ArrayList<>();


    //todo make new Object Adress which can be use by office and person
    //todo add person responsible for this office, add Office



}
