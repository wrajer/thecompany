package com.gwd.thecompany.controller;

import com.gwd.thecompany.common.CreatorXLS;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.TaskRepository;
import com.gwd.thecompany.service.TaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


//@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa
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

        modelMap.put("tasklist", taskService.getTasks());

        return "dbtasks";
    }


/*    Get Excel     */
    @GetMapping("/tasks/excel")
    public String createFile() throws NoSuchMethodException,
            IOException, IllegalAccessException, InvocationTargetException {
        CreatorXLS<Task> creatorXLS = new CreatorXLS<>(Task.class);
        creatorXLS.createFile(taskService.getTasks(), "src/main/resources", "taskList");
        return "redirect:/tasks";
    }

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

        return "tasks";

    }


    @GetMapping("/tasks/delete")
    public String deleteTask(@RequestParam Long taskid) {

        taskService.deleteTaskById(taskid);

        return "redirect:/tasks";
    }


}
