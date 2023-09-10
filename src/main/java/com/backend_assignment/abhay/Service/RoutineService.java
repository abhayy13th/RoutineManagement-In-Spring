package com.backend_assignment.abhay.Service;

import com.backend_assignment.abhay.DTO.GroupWorkHoursDTO;
import com.backend_assignment.abhay.Entity.Routine;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend_assignment.abhay.Repository.RoutineRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final EntityManager entityManager;

    @Autowired
    public RoutineService(RoutineRepository routineRepository, EntityManager entityManager) {
        this.routineRepository = routineRepository;
        this.entityManager = entityManager;
    }

    public List<Routine> getRoutine() {
        return routineRepository.findAll();
    }

    public Routine addNewRoutine(Routine routine) {

        if (routine.getR_id() != null && routineRepository.existsById(routine.getR_id())) {
            throw new IllegalStateException("Routine with id " + routine.getR_id() + " already exists");
        }
        return routineRepository.save(routine);



    }

    public void updateRoutine(Long rId, Routine routineUpdated) {
        Routine routine = routineRepository.findById(rId)
                .orElseThrow(() -> new IllegalStateException("Routine with id " + rId + " does not exists"));

        if (routineUpdated.getStartTime() != null && !routineUpdated.getStartTime().equals(routine.getStartTime())) {
            routine.setStartTime(routineUpdated.getStartTime());
        }
        if (routineUpdated.getEndTime() != null && !routineUpdated.getEndTime().equals(routine.getEndTime())) {
            routine.setEndTime(routineUpdated.getEndTime());
        }
        if (routineUpdated.getSubject() != null && !routineUpdated.getSubject().equals(routine.getSubject())) {
            routine.setSubject(routineUpdated.getSubject());
        }
        if (routineUpdated.getTeacher() != null && !routineUpdated.getTeacher().equals(routine.getTeacher())) {
            routine.setTeacher(routineUpdated.getTeacher());
        }
        if (routineUpdated.getStudentGroup() != null && !routineUpdated.getStudentGroup().equals(routine.getStudentGroup())) {
            routine.setStudentGroup(routineUpdated.getStudentGroup());
        }
        if (routineUpdated.getRoom() != null && !routineUpdated.getRoom().equals(routine.getRoom())) {
            routine.setRoom(routineUpdated.getRoom());
        }
        if (routineUpdated.getRoutineDate() != null && !routineUpdated.getRoutineDate().equals(routine.getRoutineDate())) {
            routine.setRoutineDate(routineUpdated.getRoutineDate());
        }
        routineRepository.save(routine);
    }

    public void deleteRoutine(Long rId) {
        boolean exists = routineRepository.existsById(rId);
        if (!exists) {
            throw new IllegalStateException("Routine with id " + rId + " does not exists");
        }
        routineRepository.deleteById(rId);
    }

//    private Integer getWorkHours(String teacherName) {
//        return (Integer) entityManager.createNativeQuery("select sum(time_to_sec(timediff(end_time, start_time))) from routine where teacher_id = teacherName and routine_date between '2021-09-01' and '2021-09-30'")
//                .setParameter(":teacherName", "Abhay")
//                .getSingleResult();
//    }


    public Integer getWorkHours(String teacherName, LocalDate startDate, LocalDate endDate) {
        Integer workHours = routineRepository.getWorkHours(teacherName, startDate, endDate);
        if (workHours == null) {
            return 0;
        }
        return workHours;


    }

    public Integer getGroupWorkHours(Long groupId) {
        Integer groupWorkHours = routineRepository.getGroupWorkHours(groupId);
        if (groupWorkHours == null) {
            return 0;
        }
        return groupWorkHours;
    }
}
