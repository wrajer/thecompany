package com.gwd.thecompany.common.security;

import com.gwd.thecompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 /*   private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
    }*/


    private EmployeeService employeeService;
    private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(EmployeeService employeeService, CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests() // właczam autoryzacje
                .antMatchers("/login**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                // config form in login page
                .loginProcessingUrl("/signin") // form action link
                .usernameParameter("username") //input name
                .passwordParameter("password") // input password
                .successHandler(
                        (req, res, auth) -> {
                            for (GrantedAuthority g : auth.getAuthorities()
                            ) {
                                System.out.println(g.getAuthority());

                            }
                            res.sendRedirect("/");
                        })
                .failureHandler(
                        (req, res, exp) -> {
                            String errorMessage;
                            if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                                errorMessage = "Invalid username or password";

                            } else {
                                errorMessage = "unknown error " + exp.getMessage();
                            }
                            req.getSession().setAttribute("message", errorMessage);
                            res.sendRedirect("/login");
                        }
                )
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(
                        (req, res, auth) -> {
                            res.sendRedirect("/login"); //jak źle to wraca do strony login
                        }
                )
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login"); // error: 403 handler
        http
                .csrf().disable();// odpornosc na ataki ddos
        http
                .headers().frameOptions().disable(); // for H2 memory database

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);

    }
}



/*

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //   super.configure(http);
        http.authorizeRequests() //wlacza autoryzacje. DO poinizszego "/" tak tylko indez "/**" tak daje wszystko
                .antMatchers("/login**").permitAll() //piszemy ktore moze linki sa dostępne, aby wszystko po  ** oznacza że wszystko po login będzie puszczał
                .and()
                .formLogin() //odpalanie formularzu
                .loginPage("/login")

                //config formin login page, konfiguracja loginu
                .loginProcessingUrl("signin") //form action link
                .usernameParameter("username") //input name, tylko nazwa zmiannej jak w formularzu
                .passwordParameter("password") //nawa parametru z hasłem
                .successHandler( //co robi po prawidłowm logowaniu

                        (req, res, auth) -> {
                            for (GrantedAuthority g : auth.getAuthorities()) {
                                System.out.println(g.getAuthority()); //wyswietla nam kto sie loguje
                            }
                            res.sendRedirect("/");
                        }
                )
                .failureHandler(

                        (req, res, exp) -> {
                            String errorMessage;
                            if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {

                                errorMessage = "Invalide username or Password from Kris ";
                            } else {
                                errorMessage = " unkwon error" + exp.getMessage();
                            }
                            req.getSession().setAttribute("message", errorMessage);
                            res.sendRedirect("/login");
                        }
                )
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(

                        (req, res, auth) -> {
                            res.sendRedirect("/");
                        }
                ).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/login"); //to jest bład 403 kiedy nie masz ostepu do tego miejsca

        http
                .csrf().disable();

        http.headers().frameOptions().disable(); //for H2 memory database
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder)
                .passwordEncoder(passwordEncoder);

    }
}
*/
