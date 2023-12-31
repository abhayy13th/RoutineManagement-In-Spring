package com.backend_assignment.abhay.Controller;

import com.backend_assignment.abhay.DTO.GroupWorkHoursDTO;
import com.backend_assignment.abhay.DTO.WorkHourDTO;
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

    /**
     * Get all the routines
     * @return - List of all the routines
     */
    @GetMapping
    public List<Routine> getRoutine() {
        return routineService.getRoutine();
    }

    /**
     * Add a new routine
     * @param routine - Routine to be added
     * @return - Routine added
     */
    @PostMapping(path = "/add")
    public Routine addNewRoutine(@RequestBody Routine routine) {

        return routineService.addNewRoutine(routine);
    }

    /**
     * Update a routine
     * @param r_id - ID of the routine to be updated
     * @param routine - Routine to be updated
     */

    @PutMapping(path = "/update/{r_id}")
    public void updateRoutine(@PathVariable("r_id") Long r_id, @RequestBody Routine routine) {
        routineService.updateRoutine(r_id, routine);
    }

    /**
     * Delete a routine
     * @param r_id - ID of the routine to be deleted
     */


    @DeleteMapping(path = "/delete/{r_id}")
    public void deleteRoutine(@PathVariable("r_id") Long r_id) {
        routineService.deleteRoutine(r_id);
    }

    /**
     * Get the work hours of a teacher  between two dates
     * @param workHourDTO - Teacher name, start date and end date
     * @return work hours of the teacher in the given dates
     */
    @GetMapping(path = "/getWorkHours")
    public Integer getWorkHours(@RequestBody WorkHourDTO workHourDTO) {
        return routineService.getWorkHours(workHourDTO.getTeacherName(), workHourDTO.getStartDate(), workHourDTO.getEndDate());
    }

    /**
     * Get the work hours of a group
     * @param groupWorkHoursDTO - Group id
     * @return the work hours of the group
     */

    @GetMapping(path = "/getGroupWorkHours")
    public Integer getGroupWorkHours(@RequestBody GroupWorkHoursDTO groupWorkHoursDTO) {
        return routineService.getGroupWorkHours(groupWorkHoursDTO.getGroupId());
    }

}
