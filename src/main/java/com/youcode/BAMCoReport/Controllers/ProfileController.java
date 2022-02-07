package com.youcode.BAMCoReport.Controllers;


import com.youcode.BAMCoReport.DTO.Models.ProfileDTO;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Responses.Responses;
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


    //Get methods
    @GetMapping
    public List<ProfileDTO> getProfiles() {
        return profileService.getProfiles();
    }
    @GetMapping("/findBy/{name}")
    public Profile findProfile(@PathVariable String name){
        return profileService.getProfileByName(name);
    }



    //Post method
    @PostMapping("/add")
    @ResponseBody
    public Responses addNewProfile (@RequestBody Profile profile) {
        profileService.addNewProfile(profile);
        return new Responses ("Profile added successfully");
    }



    //Update methods
    @PutMapping ("/update")
    @ResponseBody
    public Responses updateProfile (@RequestBody Profile profile) {
        profileService.updateProfile(profile);
        return new Responses ("Profile updated successfully");
    }




    //Delete method
    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses deleteProfile (@PathVariable ("id") Long id) {
        profileService.deleteProfile(id);
        return new Responses ("Profile deleted successfully");
    }

}
