package com.backend_assignment.abhay.service;

import com.backend_assignment.abhay.AbhayApplication;
import com.backend_assignment.abhay.Entity.StudentGroup;
import com.backend_assignment.abhay.Repository.GroupRepository;
import com.backend_assignment.abhay.Service.GroupService;
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
public class GroupServiceTests {
    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private GroupService groupService;

    @Test
    public void groupRepository_saveAll_returnSavedGroups() {
        //Arrange
            //Arrange
            StudentGroup group1 = StudentGroup.builder()
                    .groupName("Group1")
                    .groupFaculty("Faculty1")
                    .build();

            Mockito.when(groupRepository.save(group1)).thenReturn(group1);
            //Act
            StudentGroup savedGroups = groupService.addNewGroup(group1);

            //Assert
            Assertions.assertThat(savedGroups).isNotNull();

    }


}

