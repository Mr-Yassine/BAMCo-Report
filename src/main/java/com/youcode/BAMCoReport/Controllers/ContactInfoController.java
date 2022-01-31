package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoModel;
import com.youcode.BAMCoReport.Entities.User_contactInfo;
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
    public List<ContactInfoModel> getContactInfo() {
        return contactInfoService.getContactInfo();
    }

    @PostMapping
    public void addNewContact (@RequestBody User_contactInfo user_contactInfo) {
        contactInfoService.addNewContact(user_contactInfo);
    }
}
