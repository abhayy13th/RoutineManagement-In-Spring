package com.backend_assignment.abhay.service;

import com.backend_assignment.abhay.AbhayApplication;
import com.backend_assignment.abhay.Entity.Routine;
import com.backend_assignment.abhay.Entity.StudentGroup;
import com.backend_assignment.abhay.Entity.Teacher;
import com.backend_assignment.abhay.Repository.RoutineRepository;
import com.backend_assignment.abhay.Service.RoutineService;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = AbhayApplication.class)
@RunWith(SpringRunner.class)
public class RoutineServiceTests {

    @Mock
    private RoutineRepository routineRepository;

    @InjectMocks
    private RoutineService routineService;

    @Test
    public void routineRepository_saveAll_returnSavedRoutines() {

        Time startTime = Time.valueOf("10:00:00");
        Time endTime = Time.valueOf("11:00:00");

        //Arrange
        Teacher teacher1 = Teacher.builder()
                .name("Abhay")
                .email("abhay@gmail.com")
                .type("Full Time")
                .subject("Java")
                .build();

        StudentGroup studentGroup1 = StudentGroup.builder()
                .groupName("L2C6")
                .build();

        Routine routine1 = Routine.builder()
                .startTime(startTime)
                .endTime(endTime)
                .subject("Java")
                .teacher(teacher1)
                .studentGroup(studentGroup1)
                .room("LT-01")
                .build();

        //Act

        Mockito.when(routineRepository.save(routine1)).thenReturn(routine1);

        //Assert

        Routine savedRoutines = routineService.addNewRoutine(routine1);


    }
}
