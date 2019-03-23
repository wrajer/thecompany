/*
package com.gwd.thecompany.common.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "public")  //jśli post gres to jeszcze strzbe pisać schema = "public"
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private int active; //dlatego że i tak będzie na bazie danch 0/1

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)     //jesli ALL to jak usunie się jedna rolę to tez wszystkich użytkowników którzy mieli taka rolę, EAGER to po to aby ięcej danych pobrać z serwera bo
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//todo - add constr

    public UserApp(UserApp userApp) {
        this.name = userApp.getName(); //tworzymy
        this.password = userApp.getPassword();
        this.active = userApp.getActive();
        this.roles = userApp.getRoles();

    }

}

*/
