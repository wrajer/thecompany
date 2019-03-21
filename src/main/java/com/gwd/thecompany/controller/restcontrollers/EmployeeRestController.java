package com.gwd.thecompany.controller.restcontrollers;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.EmployeeService;
import com.gwd.thecompany.service.OfficeService;
import com.gwd.thecompany.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //returning JSON
@Scope(value = "session")
@RequestMapping("/rest")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployeesList(ModelMap modelMap) {

        // modelMap.put("dbemployees", employeeService.getEmployees() );

        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmplyee(@RequestBody Employee employee) //@RB bedzie oczekiwał takiego info jak Planet DTO
    {
        return employeeService.addEmployee(employee);

    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {

        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestBody Employee employee) {

        employeeService.deleteEmployee(employee);
    }


}
