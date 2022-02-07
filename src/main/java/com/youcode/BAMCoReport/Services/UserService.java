package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.UserDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserService {


    @Autowired
    IMapClassWithDto<User, UserDTO> userMapping;


    @Autowired
    IUserRepository userRepository;




    //get methods
    public List<UserDTO> getUsers() {
        List<User> usersList = userRepository.findAll();
        log.info("List of User called successfully");
        return userMapping.convertListToListDto(usersList, UserDTO.class);
    }

    public List<UserDTO> getUserBy(String username) {
        List<User> userList = Collections.singletonList(userRepository.findUserByUsername(username).orElse(null));
        log.info("User information called successfully");
        return userMapping.convertListToListDto(userList, UserDTO.class);
    }





    //add method
    public ResponseEntity<String> addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());

        if(userOptional.isPresent()) {
            throw new IllegalStateException("This username " + user.getUsername() + " is already taken");
        }

        userRepository.save(user);
        log.info("User added successfully");
        return new ResponseEntity<String>("User added successfully", HttpStatus.OK);
    }





    //update method
    @Transactional
    public void patchUser(Long id, String username, String password, String firstName, String jobTitle) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("User with id " + id + " does not exists")
        );


        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {

            Optional<User> userOptional = userRepository.findUserByUsername(username);

            if (userOptional.isPresent()) {
                throw new IllegalStateException ("There is already a user with " +username+ " username");
            }

            user.setUsername(username);
            log.info("User username updated successfully");
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
            log.info("User password updated successfully");
        }

        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
            log.info("User firstname updated successfully");
        }

        if (jobTitle != null && jobTitle.length() > 0 && !Objects.equals(user.getJobTitle(), jobTitle)) {
            user.setJobTitle(jobTitle);
            log.info("User jobTitle updated successfully");
        }



        log.info("User's content updated successfully");
    }


    public void updateUser(@RequestBody User u) {
        userRepository.findById(u.getId()).orElseThrow(
                ()-> new IllegalStateException("User with id " + u.getId() + " does not exists")
        );

        userRepository.save(u);
        log.info("User updated successfully");
    }






    //delete method
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
        log.info("User deleted successfully");
    }



}
