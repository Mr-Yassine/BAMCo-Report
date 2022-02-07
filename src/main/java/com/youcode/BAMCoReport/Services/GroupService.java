package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.GroupDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Repositories.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    }







    //delete method
    public void deleteGroup(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Group with id " + id + " does not exists");
        }
        groupRepository.deleteById(id);
    }





    //update method
    @Transactional
    public void updateGroup(Long id, String name) {

        Group group = groupRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Group with id " + id + " does not exists")
        );




        if (name != null && name.length() > 0 && !Objects.equals(group.getName(), name)) {

            Optional<Group> groupOptional = groupRepository.findGroupByName(name);

            if (groupOptional.isPresent()) {
                throw new IllegalStateException ("There is already a group with " +name+ " username");
            }

            group.setName(name);
        }


    }


}
