package com.gwd.thecompany.mapper;

import com.gwd.thecompany.common.Mapper;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OfficeMapper implements Mapper<Office, OfficeDto> {

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    OfficeService officeService;

    @Override
    public OfficeDto map(Office f) {

    /*    List<String> emps = f
                .getEmployeesList()
                .stream()
                .map(EmpsToStringList.INSTANCE)
                .collect(Collectors.toList());*/

        return OfficeDto
                .builder()
                .id(f.getId())
                .adress(f.getAdress())
                .costPerMonth(f.getCostPerMonth())
                .name(f.getName())
                .noOfDesks(f.getNoOfDesks())
                .employeesList(f.getEmployeesList())
               /* .employeesList(emps)*/
                .noPeople(officeService.getNoOfPeopleById(f.getId()))
                .build();
    }

    @Override
    public Office revers(OfficeDto to) {

        return Office
                .builder()
                .adress(to.getAdress())
                .costPerMonth(to.getCostPerMonth())
                .name(to.getName())
                .noOfDesks(to.getNoOfDesks())
               /* .id(to.getId())
                .employeesList(to.getEmployeesList())*/
                .build();
    }


    public enum EmpsToStringList implements Function<Employee, String> {
        INSTANCE; //bo enymy wołamy po ich instanacja, bo to statyczne pole

        @Override
        public String apply(Employee employee) {
            return employee.getName() + " " + employee.getSurname();
        }
    }
}
