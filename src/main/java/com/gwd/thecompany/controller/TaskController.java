package com.gwd.thecompany.controller;

import com.gwd.thecompany.model.Dto.TaskDto;
import com.gwd.thecompany.model.Task;
import com.gwd.thecompany.repository.TaskRepository;
import com.gwd.thecompany.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //przez to Spring w returnie bedzie nam zwracała JSON, w całym kontrollerze produkujemy tylko JSONy
@CrossOrigin //ustawienie że zerwer b nie puściłby nas przez połączneie, to zmienjszenie ograniczenia bezpieczenstwa
@RequestMapping("/api/v1") //nasz główny link posredni ktory trzeba dodać na poczatku
public class TaskController {

    //pnie trzeba ponoac dawać Autowired tutaj
    private TaskService taskService;
    private TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {

        return  taskRepository.findAll();
       // return  taskService.getTasks();
    }

    @GetMapping("/dto/tasks")
    public List<Task> getTasksDto() {


        return  taskService.getTasks();
    }



// poniżej pełen CRUD czyli kązdy element
//    @GetMapping("/dto/planets")
//    public List<PlanetDto> getPlanetsDto() {
//
//        return planetService.getPlanetsDto();
//    }
//
//    @GetMapping("/dto/planets/{planetDistance}")
//    public List<PlanetDto> getPlanetsByDistance(@PathVariable Long planetDistance) {
//
//        return planetService.getPlanetsByDistanceFromSun(planetDistance);
//
//    }

    //jeden get zaminst dwóch powyżej
//    @GetMapping("/dto/tasks")
//    public List<TaskDto> getTasksDto() {
//
//        return taskService.getTasksDto();
//    }


//    @PostMapping("/dto/planets") //to posiada Ciało a get nie posiada ciała tylko zapytanie, POST może cs wykonać, ponoć dużo więcej
//    public Planet addPlane(@RequestBody PlanetDto planetDto) //@RB bedzie oczekiwał takiego info jak Planet DTO
//    {
//        return planetService.addPlanet(planetDto);
//    }
//
//    @PutMapping("/dto/planets") //prajtycznie nic sie nie różnią, ylko że pyta aktualizuje
//    public void updatePlanet(@RequestBody PlanetDto planetDto) {
//        planetService.updatePlanet(planetDto);
//    }
//
//    @DeleteMapping("/dto/planets/{planetName}")
//    public void deletePlanet(@PathVariable String planetName) { //musi być ta sama nazwa, jeśli ma nazzywac sie inaczej to jeszcze napisac inne rzeczy
//        planetService.deletePlanet(planetName);
//    }




}
