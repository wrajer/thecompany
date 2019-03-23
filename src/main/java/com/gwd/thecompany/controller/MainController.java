package com.gwd.thecompany.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Scope(value = "session")
@Controller
public class MainController {

    @GetMapping("/")
    public String main() {

        return "test";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

}
