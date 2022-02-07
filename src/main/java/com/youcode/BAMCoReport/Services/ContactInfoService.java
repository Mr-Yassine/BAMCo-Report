package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Entities.UserContactInfo;
import com.youcode.BAMCoReport.Repositories.IContactInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ContactInfoService {


    @Autowired
    IContactInfoRepository contactInfoRepository;

    @Autowired
    IMapClassWithDto<UserContactInfo, ContactInfoDTO> contactInfoMapping;


    //get methods
    public List<ContactInfoDTO> getContactInfo() {
        List<UserContactInfo> contactInfoListList = contactInfoRepository.findAll();
        log.info("List of ContactInfo called successfully");
        return contactInfoMapping.convertListToListDto(contactInfoListList, ContactInfoDTO.class);
    }






    //add method
    public void addNewContact(UserContactInfo user_contactInfo) {
        Optional<UserContactInfo> contactInfoOptional = contactInfoRepository.findContactInfoByEmail(user_contactInfo.getEmail());

        if(contactInfoOptional.isPresent()) {
            throw new IllegalStateException("This email " + user_contactInfo.getEmail() + " is already taken");
        }

        contactInfoRepository.save(user_contactInfo);

        log.info("ContactInfo added successfully");

    }




    //update method
    public void updateContactInfo(@RequestBody UserContactInfo contactInfo) {

        contactInfoRepository.findById(contactInfo.getId()).orElseThrow(
                ()-> new IllegalStateException("User with id " + contactInfo.getId() + " does not exists")
        );

        contactInfoRepository.save(contactInfo);
        log.info("ContactInfo updated successfully");
    }






    //delete method
    public void deleteContactInfo(Long id) {
        boolean exists = contactInfoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("ContactInfo with id " + id + " does not exists");
        }
        contactInfoRepository.deleteById(id);
        log.info("ContactInfo deleted successfully");
    }

}
