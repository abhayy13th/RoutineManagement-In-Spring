package com.backend_assignment.abhay.Controller;

import com.backend_assignment.abhay.Entity.Teacher;
import com.backend_assignment.abhay.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Get all the teachers
     * @return - List of all the teachers
     */
    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }

    /**
     * Get all the teachers who are not deleted
     * @return - List of all the teachers who are not deleted
     */
    @GetMapping(path = "{teacherId}")
    public Teacher getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping(path = "/active")
    public List<Teacher> getTeacherNotDeleted() {
        return teacherService.getTeacherNotDeleted();
    }
    /**
     * Add a new teacher
     * @param teacher - Teacher to be added
     * @return - Teacher added
     */
    @PostMapping
    public Teacher registerNewTeacher(@RequestBody Teacher teacher) {
       return teacherService.addNewTeacher(teacher);
    }
    /**
     * Update a teacher
     * @param teacherId - ID of the teacher to be updated
     * @param teacher - Teacher to be updated
     */
    @PutMapping(path = "{teacherId}")
    public void updateTeacher(
            @PathVariable("teacherId") Long teacherId, @RequestBody Teacher teacher){
        teacherService.updateTeacher(teacherId, teacher);

    }
    /**
     * Delete a teacher
     * @param teacherId - ID of the teacher to be deleted
     */
    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    /**
     * Update the status of a teacher to deleted
     * @param teacherId - ID of the teacher to be updated
     */

    @PutMapping(path = "/safeDelete/{teacherId}")
    public void updateTeacherStatus(@PathVariable("teacherId") Long teacherId){
        teacherService.safeDeleteTeacherById(teacherId);
    }
}
