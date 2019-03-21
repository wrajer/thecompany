package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;


import org.springframework.web.bind.annotation.*;


@Scope(value = "session")
@Controller
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    private OfficeRepository officeRepository;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/offices")
    public String getOfficesList(ModelMap modelMap) {
        modelMap.put("offices", officeService.getOffices());
        return "dboffices";
    }


    @PostMapping("/offices/add")
    public String addOffice2(@ModelAttribute Office office) { //nie działa na zwykłym office ehh

        officeService.addOffice(office);

        return "redirect:/offices";
    }


    @GetMapping("/offices/update/{id}/send")
    public String updateOfficeSend(@ModelAttribute Office officesend) {

        //officeRepository.findById(id).get();


        officeService.updateOffice(officesend);
        officeService.addOffice(officesend);

        return "redirect:/offices";

    }

    @GetMapping("/offices/update")
    public String updateOffice(@RequestParam Long officeid,   ModelMap modelMap) {

        modelMap.put("offices", officeService.getOfficeById(officeid));
        modelMap.put("office", officeService.getOfficeById(officeid));
        modelMap.put("officetoupdate", officeService.getOfficeById(officeid));
        modelMap.put("update", "update");


        return "dboffices";

    }


    @GetMapping("/offices/delete")
    public String deleteOffice(@RequestParam Long officeid) {

        officeService.deleteOfficeById(officeid);

        return "redirect:/offices";
    }


}
