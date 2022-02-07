package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.RoleDTO;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Responses.Responses;
import com.youcode.BAMCoReport.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/api/role")
public class RoleController {


    @Autowired
    RoleService roleService;


    //Get methods
    @GetMapping
    public List<RoleDTO> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/findBy/{id}")
    public Role findRole(@PathVariable Long id){
        return roleService.getRoleById(id);
    }



    //Post method
    @PostMapping("/add")
    @ResponseBody
    public Responses addNewRole (@RequestBody Role role) {
        roleService.addNewRole(role);
        return new Responses("Role added successfully");
    }




    //Update method
    @PutMapping(path = "/update/{id}")
    @ResponseBody
    public Responses UpdateRole (
            @PathVariable ("id") Long id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String description) {

        roleService.updateRole(id, name, description);
        return new Responses ("Role Updated successfully");

    }


    //Delete method
    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses deleteRole (@PathVariable ("id") Long id) {
        roleService.deleteRole(id);
        return new Responses ("Role deleted successfully");
    }
}
