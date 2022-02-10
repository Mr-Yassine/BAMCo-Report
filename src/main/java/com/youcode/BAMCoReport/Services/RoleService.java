package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.RoleDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Repositories.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class RoleService {


    @Autowired
    IMapClassWithDto<Role, RoleDTO> roleMapping;


    @Autowired
    IRoleRepository roleRepository;



    //Get method
    public List<RoleDTO> getRoles() {
        List<Role> rolesList = roleRepository.findAll();
        return roleMapping.convertListToListDto(rolesList, RoleDTO.class);
    }
    public Role getRoleById(Long id) {
        return roleRepository.findRoleById(id).orElse(null);
    }


    //add method
    public void addNewRole(Role role) {
        Optional<Role> roleOptional = roleRepository.findRoleByName(role.getName());

        if (roleOptional.isPresent()) {
            throw new IllegalStateException("This name " + role.getName() + " is already taken");
        }

        roleRepository.save(role);
        log.info("Role added successfully");
    }


    //update method
    public void updateRole(@RequestBody Role role) {
        roleRepository.findRoleById(role.getId()).orElseThrow(
                ()-> new IllegalStateException("Role with id " + role.getId() + " does not exists")
        );

        roleRepository.save(role);
        log.info("Role updated successfully");
    }

    //delete method
    public void deleteRole(Long id) {
        boolean exists = roleRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Role with id " + id + " does not exists");
        }
        roleRepository.deleteById(id);
        log.info("Role deleted successfully");
    }



    public RoleDTO findById(Long id) {
        Role role = roleRepository.findById(id).get();
        return roleMapping.convertToDto(role, RoleDTO.class);

    }

}
