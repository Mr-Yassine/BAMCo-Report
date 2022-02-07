package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoDTO;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Entities.UserContactInfo;
import com.youcode.BAMCoReport.Responses.Responses;
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


    //Get method
    @GetMapping
    public List<ContactInfoDTO> getContactInfo() {
        return contactInfoService.getContactInfo();
    }



    //Post method
    @PostMapping("/add")
    @ResponseBody
    public Responses addNewContact (@RequestBody UserContactInfo user_contactInfo) {
        contactInfoService.addNewContact(user_contactInfo);
        return new Responses ("Contact added successfully");
    }



    //Update method
    @PutMapping ("/update")
    @ResponseBody
    public Responses UpdateContactInfo (@RequestBody UserContactInfo contactInfo) {
        contactInfoService.updateContactInfo(contactInfo);
        return new Responses ("Contact updated successfully");
    }


    //Delete method
    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses deleteContactInfo (@PathVariable ("id") Long id) {
        contactInfoService.deleteContactInfo(id);
        return new Responses ("Contact deleted successfully");
    }
}
