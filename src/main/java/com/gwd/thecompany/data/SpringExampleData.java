package com.gwd.thecompany.data;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SpringExampleData  implements CommandLineRunner {

    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start of the program");

        //----------------------------------------------------------------------
        //-----------------------Adding simple data do db-----------------------
        //----------------------------------------------------------------------
//        List<Employee> HQWarsawEmp = Arrays.asList(new Employee("Jan", "Kowalski", "eng", 12, 26000f, "plac Zamkowy 4, 00-277 Warsaw, Poland"));
//        officeRepository.save(new Office("Headquarter", 200, "plac Zamkowy 4, 00-277 Warsaw, Poland", null));
//        officeRepository.save(new Office("Headquarter", 200, "plac Zamkowy 4, 00-277 Warsaw, Poland", HQWarsawEmp));
//
//        officeRepository.save(new Office("Outter Warsaw", 50, "Przyjazna 3, 05-420 Józefów, Poland", null));
//        officeRepository.save(new Office("SouthPoland", 80, "Szkolna 5, 16-300 Rutki Nowe, Poland", null));
//        officeRepository.save(new Office( "misiek", 80, "asdas", null ));
//
//
//        employeeRepository.save(new Employee("Jan", "Kowalski", "eng", 0, 26000f, "plac Zamkowy 4, 00-277 Warsaw, Poland"));
//        employeeRepository.save(new Employee("Jan", "Kowalski", "eng", 0, 26000f, "plac Zamkowy 4, 00-277 Warsaw, Poland"));


    }
}

