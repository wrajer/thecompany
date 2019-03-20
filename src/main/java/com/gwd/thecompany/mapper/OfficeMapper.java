package com.gwd.thecompany.mapper;

import com.gwd.thecompany.common.Mapper;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OfficeMapper implements Mapper<Office, OfficeDto> {


    @Override
    public OfficeDto map(Office f) {

        List<String> emps = f
                .getEmployeesList()
                .stream()
                .map(EmpsToStringList.INSTANCE)
                .collect(Collectors.toList());


        return OfficeDto
                .builder()
                .adress(f.getAdress())
                .costPerMonth(f.getCostPerMonth())
                .name(f.getName())
                .noOfDesks(f.getNoOfDesks())
                .employeesList(emps)
                .build();
    }

    @Override
    public Office revers(OfficeDto from) {
        //todo dopisać funkcje
        return null;
    }


    public enum EmpsToStringList implements Function<Employee, String> {
        INSTANCE; //bo enymy wołamy po ich instanacja, bo to statyczne pole

        @Override
        public String apply(Employee employee) {
            return employee.getName() + " " + employee.getSurname();
        }
    }
}
