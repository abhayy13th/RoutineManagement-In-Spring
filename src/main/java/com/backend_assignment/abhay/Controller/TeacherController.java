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


    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "{teacherId}")
    public void updateTeacher(
            @PathVariable("teacherId") Long teacherId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String type) {
        teacherService.updateTeacher(teacherId, name, subject, email, type);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}
