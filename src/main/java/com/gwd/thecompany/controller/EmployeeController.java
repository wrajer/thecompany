package com.gwd.thecompany.controller;

import com.gwd.thecompany.common.CreatorXLS;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.service.EmployeeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


//@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa

//wyrzucone pre authrise
@Scope(value = "session") //todo test funcion without it
@RequestMapping("/employees")
@Controller
public class EmployeeController {

  private EmployeeRepository employeeRepository;
  private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String getEmployees(ModelMap modelMap) {

        modelMap.put("emplist", employeeRepository.findAll());

        return "dbemployees";
    }

/*    @GetMapping("/update")
    public String updateEmployee(@RequestParam Long empid, ModelMap modelMap) {

        modelMap.put("emptoupdate", employeeService.getEmployeeById(empid));

        return "dboffices";
    }*/

    @GetMapping("add")
    public String addEmployee() {

        return "employeedetails";
    }

/*    @PostMapping("/offices/add")
    public String addOffice(@ModelAttribute Office office) { //nie działa na zwykłym office ehh

        officeService.addOffice(office);

        return "redirect:/offices";
    }*/


    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long empid) {

        employeeService.deleteEmployeeById(empid);

        return "redirect:/employees";
    }

    @GetMapping("/excel")
    public String createFile() throws NoSuchMethodException,
            IOException, IllegalAccessException, InvocationTargetException {

        CreatorXLS<Employee> creatorXLS = new CreatorXLS<>(Employee.class);
        creatorXLS.createFile(employeeService.getEmployees(), "src/main/resources", "EmployeesList");

        return "redirect:/employees";
    }



}
