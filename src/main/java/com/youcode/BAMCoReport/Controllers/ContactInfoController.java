package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoDTO;
import com.youcode.BAMCoReport.Entities.UserContactInfo;
import com.youcode.BAMCoReport.Services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "/api/contactInfo")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }


    @GetMapping
    public List<ContactInfoDTO> getContactInfo() {
        return contactInfoService.getContactInfo();
    }

    @PostMapping
    public void addNewContact (@RequestBody UserContactInfo user_contactInfo) {
        contactInfoService.addNewContact(user_contactInfo);
    }
}
