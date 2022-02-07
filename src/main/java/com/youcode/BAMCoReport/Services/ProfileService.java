package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ProfileDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Repositories.IProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ProfileService {

    @Autowired
    IMapClassWithDto<Profile, ProfileDTO> profileMapping;

    @Autowired
    IProfileRepository profileRepository;



    //Get method
    public List<ProfileDTO> getProfiles() {
        List<Profile> profilesList = profileRepository.findAll();
        return profileMapping.convertListToListDto(profilesList, ProfileDTO.class);
    }
    public Profile getProfileByName(String name) {
        return profileRepository.findProfileByName(name).orElse(null);
    }


    //add method
    public void addNewProfile(Profile profile) {
        Optional<Profile> profileOptional = profileRepository.findProfileByName(profile.getName());

        if(profileOptional.isPresent()) {
            throw new IllegalStateException("This username " + profile.getName() + " is already taken");
        }

        profileRepository.save(profile);

    }


    //update method
    @Transactional
    public void patchProfile(Long id, String name, String description, User createdBy, User lastUpdateBy, User managerUserId) {

        Profile profile = profileRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Profile with id " + id + " does not exists")
        );


        if (name != null && name.length() > 0 && !Objects.equals(profile.getName(), name)) {
            profile.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(profile.getDescription(), description)) {
            profile.setDescription(description);
        }

        if (name != null && name.length() > 0 && !Objects.equals(profile.getName(), name)) {
            profile.setName(name);
        }

        log.info("Profile updated successfully");
    }

    public void updateProfile(@RequestBody Profile profile) {

        profileRepository.findById(profile.getId()).orElseThrow(
                ()-> new IllegalStateException("Profile with id " + profile.getId() + " does not exists")
        );
        profileRepository.save(profile);
        log.info("Profile updated successfully");
    }



    //delete method
    public void deleteProfile(Long id) {
        boolean exists = profileRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Profile with id " + id + " does not exists");
        }
        profileRepository.deleteById(id);
    }



}


