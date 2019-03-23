package com.gwd.thecompany.common.security;

import com.gwd.thecompany.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends Employee implements UserDetails { //do można dopisać jezcze elementy dostępowe


    public CustomUserDetails(Employee employee) {
        super(employee);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
       // return
//        return getRoles()
//                .stream()
//                .map( role -> new SimpleGrantedAuthority("ROLE_"+role.getRole())) //R
//                .collect(Collectors.toSet());
    }

    //metoda z userApp
    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    ///costam costam

    @Override
    public boolean isAccountNonExpired() { //warunki np lgin który był tylko na pewie czas
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}

