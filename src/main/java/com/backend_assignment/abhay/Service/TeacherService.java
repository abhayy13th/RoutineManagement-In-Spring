package com.backend_assignment.abhay.Service;

import com.backend_assignment.abhay.Entity.Enum.Status;
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

    public List<Teacher> getTeacherNotDeleted() {
        return teacherRepository.findAllByStatusNot();
    }

    public Teacher addNewTeacher(Teacher teacher) {
        if (teacherRepository.findTeacherByEmail(teacher.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("Teacher with id " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional
    public void updateTeacher(Long teacherId, Teacher updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id " + teacherId + " does not exists"));

        if (updatedTeacher.getName() != null && !updatedTeacher.getName().isEmpty() && !Objects.equals(updatedTeacher.getName(), teacher.getName())) {
            teacher.setName(updatedTeacher.getName());
        }

        if (updatedTeacher.getSubject() != null && !updatedTeacher.getSubject().isEmpty() && !Objects.equals(teacher.getSubject(),updatedTeacher.getSubject())) {
            teacher.setSubject(updatedTeacher.getSubject());
        }

        if (updatedTeacher.getEmail() != null && !updatedTeacher.getEmail().isEmpty() && !Objects.equals(updatedTeacher.getEmail(), teacher.getEmail())) {
            Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(updatedTeacher.getEmail());
            if (teacherOptional.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            teacher.setEmail(updatedTeacher.getEmail());

        }

        if (updatedTeacher.getType() != null && !updatedTeacher.getType().isEmpty() && !Objects.equals(teacher.getType(),updatedTeacher.getType())) {
            teacher.setType(updatedTeacher.getType());
        }
        teacherRepository.save(teacher);


    }


    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id " + teacherId + " does not exists"));
    }
    @Transactional
    public void safeDeleteTeacherById(Long teacherId){
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Teacher with id " + teacherId + " does not exists"));
        if(teacher.getStatus() == null || teacher.getStatus().isEmpty()) {
            throw new IllegalStateException("Status cannot be null or empty");
        }
        if(teacher.getStatus().equals("X")){
            throw new IllegalStateException("Teacher with id " + teacherId + " is already safe deleted");
        }

            teacher.setStatus("X");
            teacherRepository.save(teacher);

    }
}
