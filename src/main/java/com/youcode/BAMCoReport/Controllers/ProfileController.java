package com.youcode.BAMCoReport.Controllers;


import com.youcode.BAMCoReport.DTO.Models.ProfileDTO;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping
    public List<ProfileDTO> getProfiles() {
        return profileService.getProfiles();
    }
    @GetMapping("/findBy/{id}")
    public Profile findProfile(@PathVariable Long id){
        return profileService.getProfileById(id);
    }

    @PostMapping
    public void addNewProfile (@RequestBody Profile profile) {
        profileService.addNewProfile(profile);
    }

    @PutMapping(path = "{id}")
    public void UpdateProfile (
            @PathVariable ("id") Long id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String description) {

        profileService.updateProfile(id, name, description);

    }

}
