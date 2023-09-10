package com.backend_assignment.abhay.Service;
import com.backend_assignment.abhay.Entity.StudentGroup;
import com.backend_assignment.abhay.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<StudentGroup> getGroupList() {
        return groupRepository.findAll();
    }

    public StudentGroup addNewGroup(StudentGroup studentGroup) {
        if (studentGroup.getId() == null) {
           return this.groupRepository.save(studentGroup);

        }
        else{
            throw new IllegalStateException("Group with id " + studentGroup.getId() + " does not exists");
        }


    }

    public void deleteGroup(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Group with id " + id + " does not exists");
        }
        groupRepository.deleteById(id);
    }


    public void updateGroup(Long id, StudentGroup studentGroup) {
        StudentGroup group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Group with id " + id + " does not exists"));

        if (group.getGroupName() != null && !group.getGroupName().isEmpty() && !Objects.equals(group.getGroupName(), studentGroup.getGroupName())) {
            group.setGroupName(studentGroup.getGroupName());
        }
        if (group.getGroupFaculty() != null && !group.getGroupFaculty().isEmpty() && !Objects.equals(group.getGroupFaculty(), studentGroup.getGroupFaculty())) {
            group.setGroupFaculty(studentGroup.getGroupFaculty());
        }


        groupRepository.save(group);
    }
}
