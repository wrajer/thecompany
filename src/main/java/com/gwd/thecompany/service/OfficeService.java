package com.gwd.thecompany.service;

import com.gwd.thecompany.mapper.OfficeMapper;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private OfficeRepository officeRepository;
    private OfficeMapper officeMapper;
    private EmployeeRepository employeeRepository;

    public OfficeService(OfficeRepository officeRepository, OfficeMapper officeMapper, EmployeeRepository employeeRepository) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
        this.employeeRepository = employeeRepository;
    }

    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(Long officeId) {

        Optional<Office> office = officeRepository.findById(officeId);

        return office.get();
    }


/*    public Office getOfficeById2(Long officeId) {

        Optional<Office> office = officeRepository.findById(officeId);

        return office.get();
    }*/


    public Office addOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(Office office) {
        officeRepository.delete(office);
    }

    public void updateOffice(Office office) {
        officeRepository.save(office);
    }

    public void deleteOfficeById(Long officeid) {
        officeRepository.deleteById(officeid);
    }

    public Long getNoOfPeople(Long officeId) {

        Optional<Office> office = officeRepository.findById(officeId);

        return employeeRepository.getNoOfPeoleInOneOffice(office);
    }


/*
    public List<OfficeDto> getOfficessDto() {

        return officeRepository
                .findAll()
                .stream()
                .map(officeMapper::map)
                .collect(Collectors.toList());
    }

    public Office addOffice(OfficeDto officeDto) {
        return officeRepository.save(officeMapper.revers(officeDto));
    }

    public void deleteOffice(String officeName) { //nie pracujemy na ID bo Dto nie posiada ID, przez to poki co nie mozna zmieniać imienia
        //aby zapisac dodawanie planet musimy zrobić dodatkowego mappera lub poprawić obecnego
        officeRepository.deleteByOfficeName(officeName);
    }

    public void updateOffice(OfficeDto officeDto) {

        officeRepository
                .findByOfficeName(officeDto.getName())
                .ifPresent(o -> {
                    o.setAdress(officeDto.getAdress());
                    o.setCostPerMonth(officeDto.getCostPerMonth());
                    o.setNoOfDesks(officeDto.getNoOfDesks());

                    officeRepository.save(o);//to działa tak samo ja update ALTER
                });  //dajemy lambdę co ma zrobić z tym obiettem planet jeś istnieje

    }*/


}
