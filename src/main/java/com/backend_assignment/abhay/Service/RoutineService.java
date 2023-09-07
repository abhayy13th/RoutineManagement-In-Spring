package com.backend_assignment.abhay.Service;

import com.backend_assignment.abhay.Entity.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend_assignment.abhay.Repository.RoutineRepository;

import java.util.List;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    @Autowired
    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public List<Routine> getRoutine() {
        return routineRepository.findAll();
    }

    public void addNewRoutine(Routine routine) {
        if (routine.getR_id() == null) {
            this.routineRepository.save(routine);
            return;
        }
        routineRepository.findById(routine.getR_id())
                .ifPresentOrElse(
                        r -> {
                            throw new IllegalStateException("Routine with id " + routine.getR_id() + " already exists");
                        },
                        () -> {
                            routineRepository.save(routine);
                        }
                );



    }

    public void updateRoutine(Long rId, Routine routineUpdated) {
        Routine routine = routineRepository.findById(rId)
                .orElseThrow(() -> new IllegalStateException("Routine with id " + rId + " does not exists"));

        if (routineUpdated.getStartTime()!=null && !routineUpdated.getStartTime().equals(routine.getStartTime())) {
            routine.setStartTime(routineUpdated.getStartTime());
        }
        if (routineUpdated.getEndTime()!=null && !routineUpdated.getEndTime().equals(routine.getEndTime())) {
            routine.setEndTime(routineUpdated.getEndTime());
        }
        if (routineUpdated.getSubject()!=null && !routineUpdated.getSubject().equals(routine.getSubject())) {
            routine.setSubject(routineUpdated.getSubject());
        }
        if (routineUpdated.getTeacher()!=null && !routineUpdated.getTeacher().equals(routine.getTeacher())) {
            routine.setTeacher(routineUpdated.getTeacher());
        }
        if (routineUpdated.getStudentGroup()!=null && !routineUpdated.getStudentGroup().equals(routine.getStudentGroup())) {
            routine.setStudentGroup(routineUpdated.getStudentGroup());
        }
        if (routineUpdated.getRoom()!=null && !routineUpdated.getRoom().equals(routine.getRoom())) {
            routine.setRoom(routineUpdated.getRoom());
        }
        if (routineUpdated.getRoutineDate()!=null && !routineUpdated.getRoutineDate().equals(routine.getRoutineDate())) {
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
}
