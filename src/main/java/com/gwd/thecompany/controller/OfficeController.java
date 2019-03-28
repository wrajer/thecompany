package com.gwd.thecompany.controller;

import com.gwd.thecompany.common.CreatorXLS;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Dto.OfficeDtoExcel;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;


import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;


@Scope(value = "session") //todo remove scope
@Controller
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/offices")
    public String getOfficesListDto(ModelMap modelMap) {

        modelMap.put("offices", officeService.getOfficesDto());

        return "dboffices";
    }


    @PostMapping("/offices/add")
    public String addOfficeDto(@ModelAttribute OfficeDto  office) {

        officeService.addOfficeDto(office);
       // officeService.addOffice (office);

        return "redirect:/offices";
    }


    @GetMapping("/offices/addemp")
    public String addEmpToOffices(@RequestParam Long empid, @RequestParam Long officeid) {

        Optional<Employee> employee = employeeRepository.findById(empid);
        employee.get().setOffice(officeService.getOfficeById(officeid)); //zamist set mamy add, get list  pozniej add
        employeeRepository.save(employee.get());

        return "redirect:/offices";
    }

    @GetMapping("/offices/update")
    public String updateOffice(@RequestParam Long officeid, ModelMap modelMap) {

        modelMap.put("officetoupdate", officeService.getOfficeById(officeid));

        return "dboffices";
    }

    @GetMapping("/offices/delete")
    public String deleteOffice(@RequestParam Long officeid) {

        officeService.deleteOfficeById(officeid);

        return "redirect:/offices";
    }

/*    @GetMapping("/offices/excel")
    public String createFile() throws NoSuchMethodException,
            IOException, IllegalAccessException, InvocationTargetException {

        CreatorXLS<OfficeDtoExcel> creatorXLS = new CreatorXLS<>(OfficeDtoExcel.class);
        creatorXLS.createFile(officeService.getOfficesDtoExcel(), "src/main/resources", "OfficesList");

        return "redirect:/offices";
    }*/


}
