package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ProfileDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProfileService {

    private final IProfileRepository profileRepository;
    @Autowired
    IMapClassWithDto<Profile, ProfileDTO> profileMapping;


    @Autowired
    public ProfileService(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    //Get method
    public List<ProfileDTO> getProfiles() {
        List<Profile> profilesList = profileRepository.findAll();
        return profileMapping.convertListToListDto(profilesList, ProfileDTO.class);
    }
    public Profile getProfileById(Long id) {
        return profileRepository.findProfileById(id).orElse(null);
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
    public void updateProfile(Long id, String name, String description) {

        Profile profile = profileRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Profile with id " + id + " does not exists")
        );


        if (name != null && name.length() > 0 && !Objects.equals(profile.getName(), name)) {
            profile.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(profile.getDescription(), description)) {
            profile.setDescription(description);
        }

    }


}


