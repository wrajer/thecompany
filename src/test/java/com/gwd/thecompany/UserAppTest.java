package com.gwd.thecompany;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAppTest {

    private PasswordEncoder passwordEncoder;

    @Test
    public void getHash() { //ponoć wypisuje hasło w hashcode
        passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("admin"); //generuje nam hasło dla słowa test
        String passUser = passwordEncoder.encode("user");
        System.out.println("Admin : " + passAdmin);
        System.out.println("User : " + passUser);

    }
}

