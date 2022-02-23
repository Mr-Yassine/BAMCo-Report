package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.UserDTO;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Responses.Responses;
import com.youcode.BAMCoReport.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }




    //Get methods
    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/findBy/{username}")
    public List<UserDTO> findUser(@PathVariable String username){
        return userService.getUserBy(username);
    }




    //Post method
    @PostMapping("/add")
    @ResponseBody
    public Responses addNewUser (@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addNewUser(user);
        return new Responses ("User added successfully");
    }



    //Update method
    @PutMapping ("/update")
    @ResponseBody
    public Responses updateUser (@RequestBody User user) {
        userService.updateUser(user);
        return new Responses ("User updated successfully");
    }




    //Delete method
    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses deleteUser (@PathVariable ("id") Long id) {
        userService.deleteUser(id);
        return new Responses ("User deleted successfully");
    }
}
