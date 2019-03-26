package com.gwd.thecompany.controller.restcontrollers;

import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
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
public class OfficeRestController {


    @Autowired
    private OfficeService officeService;


    @GetMapping("/offices")
    public List<Office> getOfficesList() {

        return officeService.getOffices();
    }


    @PostMapping("/offices")
    public Office addOffice(@RequestBody OfficeDto office) {

        return officeService.addOfficeDto(office);

    }

    @PutMapping("/offices")
    public void updateOffice(@RequestBody Office office) {

        officeService.updateOffice(office);
    }

    @DeleteMapping("/offices")
    public void deleteOffice(@RequestBody Office office) {

        officeService.deleteOffice(office);
    }


}
