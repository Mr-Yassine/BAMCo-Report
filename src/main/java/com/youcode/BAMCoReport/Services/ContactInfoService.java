package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.UserContactInfo;
import com.youcode.BAMCoReport.Repositories.IContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class ContactInfoService {

    private final IContactInfoRepository contactInfoRepository;
    @Autowired
    IMapClassWithDto<UserContactInfo, ContactInfoDTO> contactInfoMapping;


    @Autowired
    public ContactInfoService(IContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @GetMapping
    public List<ContactInfoDTO> getContactInfo() {
        List<UserContactInfo> contactInfoListList = contactInfoRepository.findAll();
        return contactInfoMapping.convertListToListDto(contactInfoListList, ContactInfoDTO.class);
    }


    public void addNewContact(UserContactInfo user_contactInfo) {
        Optional<UserContactInfo> contactInfoOptional = contactInfoRepository.findContactInfoByEmail(user_contactInfo.getEmail());

        if(contactInfoOptional.isPresent()) {
            throw new IllegalStateException("This email " + user_contactInfo.getEmail() + " is already taken");
        }

        contactInfoRepository.save(user_contactInfo);
    }
}
