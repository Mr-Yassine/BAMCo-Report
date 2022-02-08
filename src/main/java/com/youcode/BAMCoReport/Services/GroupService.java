package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.GroupDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Repositories.IGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class GroupService {

    private final IGroupRepository groupRepository;
    @Autowired
    IMapClassWithDto<Group, GroupDTO> groupMapping;

    @Autowired
    public GroupService(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }




    //get methods
    public List<GroupDTO> getGroups() {
        List<Group> groupsList = groupRepository.findAll();
        return groupMapping.convertListToListDto(groupsList, GroupDTO.class);
    }
    public Group getGroupByName(String name) {
        return groupRepository.findGroupByName(name).orElse(null);
    }





    //add method
    public void addNewGroup(Group group) {
        Optional<Group> groupOptional = groupRepository.findGroupByName(group.getName());

        if(groupOptional.isPresent()) {
            throw new IllegalStateException("This name " + group.getName() + " is already taken");
        }

        groupRepository.save(group);
        log.info("Group added successfully");
    }





    //update method
    public void updateGroup(@RequestBody Group group) {

        groupRepository.findById(group.getId()).orElseThrow(
                ()-> new IllegalStateException("Group with id " + group.getId() + " does not exists")
        );

        groupRepository.save(group);
        log.info("Group updated successfully");
    }




    //delete method
    public void deleteGroup(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Group with id " + id + " does not exists");
        }
        groupRepository.deleteById(id);
        log.info("Group deleted successfully");
    }


}
