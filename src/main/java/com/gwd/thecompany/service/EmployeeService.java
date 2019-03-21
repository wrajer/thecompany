package com.gwd.thecompany.service;

import com.gwd.thecompany.mapper.EmployeeMapper;
import com.gwd.thecompany.mapper.OfficeMapper;
import com.gwd.thecompany.model.Dto.EmployeeDto;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void updateEmployee (Employee employee) {

        employeeRepository.save(employee);
    }


    public List<EmployeeDto> getEmployeeDto() {

        return employeeRepository
                .findAll()
                .stream()
                .map(employeeMapper::map)
                .collect(Collectors.toList());
    }

//    public Employee addEmployee(EmployeeDto employeeDto) {
//        return employeeRepository.save(employeeMapper.revers(employeeDto));
//    }

    public void updateEmployee(EmployeeDto officeDto) {
//todo dopisać dunkcje update i delete

//        employeeRepository
//                .findByOfficeName(officeDto.getName())
//                .ifPresent(o -> {
//                    o.setAdress(officeDto.getAdress());
//                    o.setCostPerMonth(officeDto.getCostPerMonth());
//                    o.setNoOfDesks(officeDto.getNoOfDesks());
//
//                    officeRepository.save(o);//to działa tak samo ja update ALTER
//                });  //dajemy lambdę co ma zrobić z tym obiettem planet jeś istnieje

    }


}
