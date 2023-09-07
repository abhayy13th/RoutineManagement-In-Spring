package com.backend_assignment.abhay.Controller;

import com.backend_assignment.abhay.Entity.Routine;
import com.backend_assignment.abhay.Service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {
    private final RoutineService routineService;


    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }
    @GetMapping
    public List<Routine> getRoutine() {
        return routineService.getRoutine();
    }
    @PostMapping(path = "/add")
    public void addNewRoutine(@RequestBody Routine routine) {
        routineService.addNewRoutine(routine);
    }
    @PutMapping(path = "/update/{r_id}")
    public void updateRoutine(@PathVariable("r_id") Long r_id, @RequestBody Routine routine) {
        routineService.updateRoutine(r_id, routine);
    }

    @DeleteMapping(path = "/delete/{r_id}")
    public void deleteRoutine(@PathVariable("r_id") Long r_id) {
        routineService.deleteRoutine(r_id);
    }


}
