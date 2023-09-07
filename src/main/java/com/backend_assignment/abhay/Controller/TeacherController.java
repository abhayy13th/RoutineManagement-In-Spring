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
    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }


    @GetMapping(path = "{teacherId}")
    public Teacher getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping(path = "/active")
    public List<Teacher> getTeacherNotDeleted() {
        return teacherService.getTeacherNotDeleted();
    }


    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "{teacherId}")
    public void updateTeacher(
            @PathVariable("teacherId") Long teacherId, @RequestBody Teacher teacher){
        teacherService.updateTeacher(teacherId, teacher);

    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
    @PutMapping(path = "/safedelete/{teacherId}")
    public void updateTeacherStatus(@PathVariable("teacherId") Long teacherId){
        teacherService.safeDeleteTeacherById(teacherId);
    }
}
