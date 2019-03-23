package com.gwd.thecompany.common.security;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService { //sprawdzanie czy istnieje osoba o logiie a następnie porównuje hasła

    EmployeeRepository employeeRepository;


    public CustomUserService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Employee> user = employeeRepository.findEmployeeByName(name);

        user.orElseThrow(() -> new UsernameNotFoundException("user not found info from admin!"));  //jeśli jest użytkownik to jest ok a jeśli nie to wyrzuca coś

        return user.map(CustomUserDetails::new).get();  //::towrzy nowy obiek userdetails od metody get(), jeśli jest


//        CustomUserDetails cuds = new CustomUserService(user.get());
//        return cuds;
    }


}

