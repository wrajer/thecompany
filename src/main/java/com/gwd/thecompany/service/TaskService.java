package com.gwd.thecompany.service;

import com.gwd.thecompany.mapper.OfficeMapper;
import com.gwd.thecompany.mapper.TaskMapper;
import com.gwd.thecompany.model.Dto.OfficeDto;
import com.gwd.thecompany.model.Dto.TaskDto;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.OfficeRepository;
import com.gwd.thecompany.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;


    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    public List<TaskDto> getTasksDto() {

        return taskRepository
                .findAll()
                .stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
 /*   public Task addTask(TaskDto taskDto) {
        return taskRepository.save(taskMapper.revers(taskDto));
    }*/

    public void deleteTaskById(Long taskid) {
        taskRepository.deleteById(taskid);
    }

    public void updateTsk(Task task) {
        taskRepository.save(task);
    }

    //tasks
//    public void deleteOffice(String officeName) { //nie pracujemy na ID bo Dto nie posiada ID, przez to poki co nie mozna zmieniać imienia
//        //aby zapisac dodawanie planet musimy zrobić dodatkowego mappera lub poprawić obecnego
//        officeRepository.deleteByOfficeName(officeName);
//    }
//
//    public void updateOffice(OfficeDto officeDto) {
//
//        officeRepository
//                .findByOfficeName(officeDto.getName())
//                .ifPresent(o -> {
//                    o.setAdress(officeDto.getAdress());
//                    o.setCostPerMonth(officeDto.getCostPerMonth());
//                    o.setNoOfDesks(officeDto.getNoOfDesks());
//
//                    officeRepository.save(o);//to działa tak samo ja update ALTER
//                });  //dajemy lambdę co ma zrobić z tym obiettem planet jeś istnieje
//
//    }


}
