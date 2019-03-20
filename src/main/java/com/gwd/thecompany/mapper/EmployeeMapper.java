package com.gwd.thecompany.mapper;

import com.gwd.thecompany.common.Mapper;
import com.gwd.thecompany.model.Dto.EmployeeDto;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {


    @Override
    public EmployeeDto map(Employee f) {


        List<String> tasks = f
                .getTasks()
                .stream()
                .map(TastToStringList.INSTANCE)
                .collect(Collectors.toList());


        return EmployeeDto
                .builder()
                .adress(f.getAdress())
                .email(f.getEmail())
                .name(f.getName())
                .login(f.getLogin())
                .office(f.getOffice())
                .position(f.getPosition())
                .salary(f.getSalary())
                .superiorId(f.getSuperiorId())
                .surname(f.getSurname())
                .start_at(f.getStart_at())
                .tasks(tasks)
                .build();

    }

    @Override
    public Employee revers(EmployeeDto from) {

        //todo dopiac
        return null;
    }

    private enum TastToStringList implements Function<Task, String> {
        INSTANCE; //bo enymy wołamy po ich instanacja, bo to statyczne pole

        @Override
        public String apply(Task task ) {
            return task.getName();
        }
    }
}
