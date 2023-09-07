package com.backend_assignment.abhay.Controller;

import com.backend_assignment.abhay.Entity.StudentGroup;
import com.backend_assignment.abhay.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<StudentGroup> getGroup() {
        return groupService.getGroupList();
    }

    @PostMapping(path = "/add")
    public void addNewGroup(@RequestBody StudentGroup studentGroup) {
        groupService.addNewGroup(studentGroup);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
    }

    @PutMapping(path = "/update/{id}")
    public void updateGroup(@PathVariable("id") Long id, @RequestBody StudentGroup studentGroup) {
        groupService.updateGroup(id, studentGroup);
    }

}
