package com.backend_assignment.abhay.Service;

import com.backend_assignment.abhay.Entity.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    public List<Teacher> getTeacher() {
        return List.of(
                new Teacher(
                "Abhay",
                "Maths",
                "abhay@gmail.com",
                "Active",
                "Full-time"));

    }
}
