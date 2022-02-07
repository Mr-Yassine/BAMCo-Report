package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.MembershipDTO;
import com.youcode.BAMCoReport.Entities.UserMembership;
import com.youcode.BAMCoReport.Responses.Responses;
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
    @GetMapping("/findBy/{id}")
    public UserMembership findMembership(@PathVariable Long id){
        return membershipService.getMembershipBy(id);
    }


    @PostMapping("/add")
    @ResponseBody
    public Responses addNewMembership (@RequestBody UserMembership userMembership) {
        membershipService.addNewMembership(userMembership);
        return new Responses ("Membership added successfully");
    }



    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses DeleteMembership (@PathVariable ("id") Long id) {
        membershipService.deleteMembership(id);
        return new Responses ("Membership deleted successfully");
    }
}
