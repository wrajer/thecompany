package com.gwd.thecompany.controller;

import com.gwd.thecompany.common.CreatorXLS;
import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.EmployeeRepository;
import com.gwd.thecompany.repository.TaskRepository;
import com.gwd.thecompany.service.TaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;


//@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa
@Scope(value = "session")
@RequestMapping("/tasks")
@Controller
public class TaskController {

    private TaskService taskService;
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public String getTasks(ModelMap modelMap) {

        modelMap.put("tasklist", taskService.getTasks());

        return "dbtasks";
    }


    /*    Get Excel     */
    @GetMapping("/excel")
    public String createFile() throws NoSuchMethodException,
            IOException, IllegalAccessException, InvocationTargetException {
        CreatorXLS<Task> creatorXLS = new CreatorXLS<>(Task.class);
        creatorXLS.createFile(taskService.getTasks(), "src/main/resources", "taskList");
        return "redirect:/tasks";
    }

    @ResponseBody
    @GetMapping("/json")
    public List<Task> getTasksjson(ModelMap modelMap) {

        modelMap.put("tasks", taskService.getTasks());

        return taskService.getTasks();
    }


    @PostMapping("/add")
    public String addTask(@ModelAttribute Task taskadd) {

        taskService.addTask(taskadd);

        return "redirect:/tasks";
    }

    @GetMapping("/addemp")
    public String addEmpToTask(@RequestParam Long empid, @RequestParam Long taskid) {

        Optional<Employee> employee = employeeRepository.findById(empid);
        employee.get().getTasks().add(taskRepository.findById(taskid).get());
        employeeRepository.save(employee.get());

        return "redirect:/tasks";
    }


    @GetMapping("/update")
    public String updateTask(@RequestParam Long taskid, ModelMap modelMap) {
        //  System.out.println(officeService.getNoOfPeople(officeid));

        //modelMap.put("tasks", taskService.updateTask(task);)
        modelMap.put("update", "update");

        return "tasks";

    }


    @GetMapping("/delete")
    public String deleteTask(@RequestParam Long taskid) {

        taskService.deleteTaskById(taskid);

        return "redirect:/tasks";
    }


}
