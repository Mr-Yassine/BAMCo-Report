package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.RoleDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

        if(roleOptional.isPresent()) {
            throw new IllegalStateException("This name " + role.getName() + " is already taken");
        }

        roleRepository.save(role);

    }


    //update method
    @Transactional
    public void updateRole(Long id, String name, String description) {

        Role role = roleRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Role with id " + id + " does not exists")
        );


        if (name != null && name.length() > 0 && !Objects.equals(role.getName(), name)) {
            role.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(role.getDescription(), description)) {
            role.setDescription(description);
        }

    }


    //delete method
    public void deleteRole(Long id) {
        boolean exists = roleRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Role with id " + id + " does not exists");
        }
        roleRepository.deleteById(id);
    }

}
