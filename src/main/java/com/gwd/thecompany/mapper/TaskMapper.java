package com.gwd.thecompany.mapper;

import com.gwd.thecompany.common.Mapper;
import com.gwd.thecompany.model.Dto.EmployeeDto;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Dto.TaskDto;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TaskMapper implements Mapper<Task, TaskDto> {


    @Override
    public TaskDto map(Task from) {

        List<String> emps = from
                .getTaskEmpList()
                .stream()
                .map(OfficeMapper.EmpsToStringList.INSTANCE)
                .collect(Collectors.toList());

        return TaskDto
                .builder()
                .description(from.getDescription())
                .end_at(from.getEnd_at())
                .name(from.getName())
                .priority(from.getPriority())
                .start_at(from.getStart_at())
                .taskEmpList(emps)
                .build();
    }

    @Override
    public Task revers(TaskDto from) {
        //todo dopisać
        return null;
    }

}
