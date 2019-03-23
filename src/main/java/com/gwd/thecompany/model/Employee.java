package com.gwd.thecompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@AllArgsConstructor //ten do wywalenia i nadpisać login,
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {

 // {noop} wymyślone hasło
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "emp_name")
    private String name;
    @NotNull
    @Size(max = 20)
    @Column(name = "emp_surname")
    private String surname;
    @Column(name = "emp_password")
    private String password; //ok
    @Column(name = "emp_email")
    private String email;
    @Column(name = "emp_login")
    private String login; //
    @Column(name = "emp_position")
    private String position;
    @Column(name = "emp_access")
    private String access;
    @Column(name = "emp_sup_id")
    private Integer superiorId;

    @Column(name = "emp_salary")
    private Float salary;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "epm_hire_data")
    private Date start_at= new Date();

    @ManyToOne
    private Office office;

    @Column(name = "emp_adress")
    private String adress;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (
            name="emp_task",//nazwa nowej tabeli
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name="task_id"))
    private List<Task> tasks = new ArrayList<>();

    //todo make new Object Adress which can be use by office and person
    //todo add hire date etc


    public Employee(Long id, String name, String surname, String password, String email, String login, String position, String access, Integer superiorId, Float salary, Date start_at, Office office, String adress, List<Task> tasks) {
        this.id = id;
        this.name = name+"."+surname ; //todo spróbuj dodać ID jeśli będ
        this.surname = surname;
        this.password = password;
        this.email = this.login+"@the.com";
        this.login = login;
        this.position = position;
        this.access = access;
        this.superiorId = superiorId;
        this.salary = salary;
        this.start_at = start_at;
        this.office = office;
        this.adress = adress;
        this.tasks = tasks;
    }

// added for security

    public Employee(Employee employee) {
        this.name=employee.getName();
        this.login = employee.getLogin();
        this.access = employee.getAccess();
        this.password = employee.getPassword();
    }

}
