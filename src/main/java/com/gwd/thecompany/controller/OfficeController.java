package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;


import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Scope(value = "session")
@Controller
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/offices")
    public String getOfficesList(ModelMap modelMap) {
        modelMap.put("offices", officeService.getOffices());
        return "dboffices";
    }


    @GetMapping("/officesdto")
    public String getOfficesListDto(ModelMap modelMap) {

        modelMap.put("offices", officeService.getOfficesDto());

        return "dboffices";
    }


    @PostMapping("/offices/add")
    public String addOffice2(@ModelAttribute Office office) { //nie działa na zwykłym office ehh

        officeService.addOffice(office);

        return "redirect:/offices";
    }

    @GetMapping("/offices/addemp")
    public String addEmpToOffices(@RequestParam Long empid, @RequestParam Long officeid) {

        //officeRepository.findById(officeid).get().addEmpToList(employeeRepository.findById(empid).get());

        Optional<Employee> employee = employeeRepository.findById(empid);
        employee.get().setOffice(officeRepository.findById(officeid).get()); //zamist set mamy add, get list  pozniej add
        employeeRepository.save(employee.get());

        //   modelMap.put("offices", officeService.getOfficesDto());

        return "redirect:/officesdto";
    }

    @GetMapping("/offices/update/{id}/send")
    public String updateOfficeSend(@ModelAttribute Office officesend) {

        officeService.updateOffice(officesend);
        officeService.addOffice(officesend);

        return "redirect:/offices";
    }

    @GetMapping("/offices/update")
    public String updateOffice(@RequestParam Long officeid, ModelMap modelMap) {

        modelMap.put("offices", officeService.getOfficeById(officeid));
        modelMap.put("office", officeService.getOfficeById(officeid));
        modelMap.put("officetoupdate", officeService.getOfficeById(officeid));
        modelMap.put("update", "update");

        return "dboffices";
    }


    @GetMapping("/offices/delete")
    public String deleteOffice(@RequestParam Long officeid) {

        officeService.deleteOfficeById(officeid);

        return "redirect:/officesdto";
    }

}

class Question {
    private String description;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
}