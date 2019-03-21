package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Dto.TaskDto;
import com.gwd.thecompany.model.Office;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.TaskRepository;
import com.gwd.thecompany.service.TaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa
@Scope(value = "session")
@Controller
public class TaskController {

    private TaskService taskService;
    private TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public String getTasks(ModelMap modelMap) {

        modelMap.put("tasks", taskService.getTasks());
        return "dbtasks";
    }


    @PostMapping("/tasks/add")
    public String addTask(@ModelAttribute Task task) {

        taskService.addTask(task);

        return "redirect:/tasks";
    }


    @GetMapping("/tasks/update")
    public String updateTask(@RequestParam Long taskid, ModelMap modelMap) {
        //  System.out.println(officeService.getNoOfPeople(officeid));

        //modelMap.put("tasks", taskService.updateTask(task);)
        modelMap.put("update", "update");

        return "dboffices";

    }


    @GetMapping("/tasks/delete")
    public String deleteTask(@RequestParam Long taskid) {

        taskService.deleteTaskById(taskid);

        return "redirect:/offices";
    }


}
