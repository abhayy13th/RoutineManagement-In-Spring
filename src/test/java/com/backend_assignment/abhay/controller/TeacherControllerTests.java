package com.backend_assignment.abhay.controller;

import com.backend_assignment.abhay.Controller.TeacherController;
import com.backend_assignment.abhay.Service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = TeacherController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TeacherControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void teacherController_getTeacher_returnAllTeachers() throws Exception {
        //Arrange

        //Act

        //Assert

    }


}
