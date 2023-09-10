package com.backend_assignment.abhay.service;

import com.backend_assignment.abhay.AbhayApplication;
import com.backend_assignment.abhay.Entity.Teacher;
import com.backend_assignment.abhay.Repository.TeacherRepository;
import com.backend_assignment.abhay.Service.TeacherService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = AbhayApplication.class)
@RunWith(SpringRunner.class)
public class TeacherServiceTests {

    @Mock
    private TeacherRepository teacherRepository;


    @InjectMocks
    private TeacherService teacherService;

    @Test
     public void teacherRepository_saveAll_returnSavedTeachers() {

         //Arrange
         Teacher teacher1 = Teacher.builder()
                 .name("Abhay")
                 .email("abhay@gmail.com")
                 .type("Full Time")
                 .subject("Java")
                 .build();
         Mockito.when(teacherRepository.save(teacher1)).thenReturn(teacher1);
         //Act
         Teacher savedTeachers = teacherService.addNewTeacher(teacher1);

         //Assert
         Assertions.assertThat(savedTeachers).isNotNull();

     }
}
