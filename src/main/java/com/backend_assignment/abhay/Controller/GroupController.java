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

    /**
     * Get all the groups
     * @return - List of all the groups
     */
    @GetMapping
    public List<StudentGroup> getGroup() {
        return groupService.getGroupList();
    }

    /**
     * Add a new group
     * @param studentGroup - Group to be added
     * @return - Group added
     */

    @PostMapping(path = "/add")
    public StudentGroup addNewGroup(@RequestBody StudentGroup studentGroup) {
        return groupService.addNewGroup(studentGroup);
    }

    /**
     * Delete a group
     * @param id - ID of the group to be deleted
     */

    @DeleteMapping(path = "/delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
    }

    /**
     * Update a group
     * @param id - ID of the group to be updated
     * @param studentGroup - Group to be updated
     */

    @PutMapping(path = "/update/{id}")
    public void updateGroup(@PathVariable("id") Long id, @RequestBody StudentGroup studentGroup) {
        groupService.updateGroup(id, studentGroup);
    }



}
