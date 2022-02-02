package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.MembershipDTO;
import com.youcode.BAMCoReport.Entities.UserMembership;
import com.youcode.BAMCoReport.Services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/membership")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }


    @GetMapping
    public List<MembershipDTO> getMembership() {
        return membershipService.getMembership();
    }

    @PostMapping
    public void addNewMembership (@RequestBody UserMembership userMembership) {
        membershipService.addNewMembership(userMembership);
    }

    @PutMapping(path = "{id}")
    public void UpdateMembership (
            @PathVariable ("id") Long id,
            @RequestParam (required = false) String username,
            @RequestParam (required = false) String password,
            @RequestParam (required = false) String firstName,
            @RequestParam (required = false) String jobTitle) {

        membershipService.updateMembership(id, username, password, firstName, jobTitle);

    }

    @DeleteMapping(path = "{id}")
    public void DeleteMembership (@PathVariable ("id") Long id) {
        membershipService.deleteMembership(id);
    }
}
