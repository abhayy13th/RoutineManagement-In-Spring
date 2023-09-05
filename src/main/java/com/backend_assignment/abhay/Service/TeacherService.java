package com.backend_assignment.abhay.Service;

import com.backend_assignment.abhay.Entity.Teacher;
import com.backend_assignment.abhay.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
       teacherRepository.findTeacherByEmail(teacher.getEmail())
               .ifPresentOrElse(
                       t -> {
                           throw new IllegalStateException("Email already taken");
                       },
                       () -> {
                           teacherRepository.save(teacher);
                       });

    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("Teacher with id " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional
    public void updateTeacher(Long teacherId, String name, String subject, String email, String type) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id " + teacherId + " does not exists"));

        if (name != null && !name.isEmpty() && !Objects.equals(name, teacher.getName())) {
            teacher.setName(name);
        }

        if (subject != null && !subject.isEmpty() && !Objects.equals(teacher.getSubject(),subject)) {
            teacher.setSubject(subject);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(email, teacher.getEmail())) {
            Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(email);
            if (teacherOptional.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            teacher.setEmail(email);

        }

        if (type != null && !type.isEmpty() && !Objects.equals(teacher.getType(),type)) {
            teacher.setType(type);
        }

    }


    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id " + teacherId + " does not exists"));
    }
}
