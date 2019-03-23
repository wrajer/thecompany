package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.TaskRepository;
import com.gwd.thecompany.service.EmployeeService;
import com.gwd.thecompany.service.TaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa

//wyrzucone pre authrise
@Scope(value = "session")
@Controller
public class EmployeeController {

  private EmployeeRepository employeeRepository;
  private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("/employess")
    public String getEmployees(ModelMap modelMap) {

        modelMap.put("emplist", employeeRepository.findAll());

        return "dbemp";
    }



/*
   @ResponseBody
    @GetMapping("/tasksjson")
    public List<Task> getTasksjson(ModelMap modelMap) {

        modelMap.put("tasks", taskService.getTasks());

        return taskService.getTasks();
    }


    @PostMapping("/tasks/add")
    public String addTask(@ModelAttribute Task taskadd) {

        taskService.addTask(taskadd);

        return "redirect:/tasks";
    }


    @GetMapping("/tasks/update")
    public String updateTask(@RequestParam Long taskid, ModelMap modelMap) {
        //  System.out.println(officeService.getNoOfPeople(officeid));

        //modelMap.put("tasks", taskService.updateTask(task);)
        modelMap.put("update", "update");

        return "tasks";*/

   // }

//
//    @GetMapping("/tasks/delete")
//    public String deleteTask(@RequestParam Long taskid) {
//
//        taskService.deleteTaskById(taskid);
//
//        return "redirect:/tasks";
//    }


}
