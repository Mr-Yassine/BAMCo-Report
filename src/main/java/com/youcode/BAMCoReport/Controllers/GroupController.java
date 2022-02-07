package com.youcode.BAMCoReport.Controllers;


import com.youcode.BAMCoReport.DTO.Models.GroupDTO;
import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Responses.Responses;
import com.youcode.BAMCoReport.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (path = "api/group")
public class GroupController {


    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }



    @GetMapping
    public List<GroupDTO> getGroups() {
        return groupService.getGroups();
    }
    @GetMapping("/findBy/{name}")
    public Group findGroup(@PathVariable String name){
        return groupService.getGroupByName(name);
    }





    @PostMapping("/addGroup")
    @ResponseBody
    public Responses addNewGroup (@RequestBody Group group) {
        groupService.addNewGroup(group);
        return new Responses ("Group added successfully");
    }





    @PutMapping(path = "/update/{id}")
    @ResponseBody
    public Responses UpdateGroup (
            @PathVariable ("id") Long id,
            @RequestParam (required = false) String name) {

        groupService.updateGroup(id, name);
        return new Responses ("Group updated successfully");

    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses DeleteGroup (@PathVariable ("id") Long id) {
        groupService.deleteGroup(id);
        return new Responses ("Group deleted successfully");
    }


}
