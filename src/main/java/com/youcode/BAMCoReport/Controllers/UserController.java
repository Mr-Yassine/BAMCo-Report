package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.UserDTO;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/api/user")
public class UserController {



    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addNewUser (@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "{id}")
    public void UpdateUser (
            @PathVariable ("id") Long id,
            @RequestParam (required = false) String username,
            @RequestParam (required = false) String password,
            @RequestParam (required = false) String firstName,
            @RequestParam (required = false) String jobTitle) {

        userService.updateUser(id, username, password, firstName, jobTitle);

    }

    @DeleteMapping(path = "{id}")
    public void DeleteUser (@PathVariable ("id") Long id) {
        userService.deleteUser(id);
    }
}
