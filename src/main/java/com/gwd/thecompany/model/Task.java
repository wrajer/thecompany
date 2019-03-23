package com.gwd.thecompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String priority;

    @JsonIgnore //Json ignore istotne przy polaczeniach tabel w bazach danych
    @ManyToMany(mappedBy = "tasks")
    private List<Employee> taskEmpList = new ArrayList<>();

    //   @NotNull
   /* @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Start_at")
    private Date start_at = new Date();*/
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "End_at")
//    private Date end_at = new Date();


    @Column(name = "Start_at")
    private String start_at;


    @Column(name = "End_at")
    private String end_at ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getName().equals(task.getName()) &&
                getDescription().equals(task.getDescription()) &&
                getPriority().equals(task.getPriority()) &&
                getStart_at().equals(task.getStart_at()) &&
                getEnd_at().equals(task.getEnd_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPriority(), getStart_at(), getEnd_at());
    }
}
