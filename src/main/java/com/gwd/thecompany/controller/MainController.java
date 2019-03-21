package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.EmployeeService;
import com.gwd.thecompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController //givin JSON
@Scope(value = "session")
@Controller
public class MainController {
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////


    // @ResponseBody
    @GetMapping ("/")
    public String dbOffices(ModelMap modelMap) {

        modelMap.put("offices", officeService.getOffices() );


        return "dboffices";
    }

    //@ResponseBody
    @GetMapping ("/dbemp")
    public List<Employee> dbEmp(ModelMap modelMap) {

        modelMap.put("dbemployees", employeeService.getEmployees() );
       //  modelMap.put("dboffices", officeRepository.findAll());


        // return employeeRepository.findAll();

        return employeeRepository.findAll();
    }

}
