package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.UserModel;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserService {

    private final IUserRepository userRepository;
    @Autowired
    IMapClassWithDto<User, UserModel> userMapping;


    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //get method
    public List<UserModel> getUsers() {
        List<User> usersList = userRepository.findAll();
        return userMapping.convertListToListDto(usersList, UserModel.class);
    }



    //add method
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());

        if(userOptional.isPresent()) {
            throw new IllegalStateException("This username " + user.getUsername() + " is already taken");
        }

        userRepository.save(user);
    }


    //delete method
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
    }


    //update method
    @Transactional
    public void updateUser(Long id, String username, String password, String firstName, String jobTitle) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("User with id " + id + " does not exists")
        );


        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }

        if (jobTitle != null && jobTitle.length() > 0 && !Objects.equals(user.getJobTitle(), jobTitle)) {
            user.setJobTitle(jobTitle);
        }

        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {

            Optional<User> studentOptional = userRepository.findUserByUsername(username);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException ("There is already a user with " +username+ " username");
            }

            user.setUsername(username);
        }


    }

}
