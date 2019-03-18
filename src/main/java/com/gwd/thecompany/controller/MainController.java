package com.gwd.thecompany.controller;

import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Scope(value = "session")
@Controller
public class MainController {

    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

   // @ResponseBody
    @GetMapping ("/")
    public String dbOffices(ModelMap modelMap) {

        modelMap.put("dboffices", officeRepository.findAll());

        return "dboffices";
    }

}
