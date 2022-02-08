package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.ProfileMemberDTO;
import com.youcode.BAMCoReport.Entities.ProfileMember;
import com.youcode.BAMCoReport.Responses.Responses;
import com.youcode.BAMCoReport.Services.ProfileMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/profileMember")
public class ProfileMemberController {



    private final ProfileMemberService profileMemberService;

    @Autowired
    public ProfileMemberController(ProfileMemberService profileMemberService) {
        this.profileMemberService = profileMemberService;
    }


    @GetMapping
    public List<ProfileMemberDTO> getProfileMembers() {
        return profileMemberService.getProfileMembers();
    }

    @PostMapping("/add")
    @ResponseBody
    public Responses addNewProfileMember (@RequestBody ProfileMember profileMember) {
        profileMemberService.addNewProfileMember(profileMember);
        return new Responses("Profile member added successfully");
    }



    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses DeleteProfileMember (@PathVariable ("id") Long id) {
        profileMemberService.deleteProfileMember(id);
        return new Responses ("Profile member deleted successfully");
    }
}
