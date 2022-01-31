package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ContactInfoModel;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Profile;
import com.youcode.BAMCoReport.Entities.User_contactInfo;
import com.youcode.BAMCoReport.Repositories.IContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class ContactInfoService {

    private final IContactInfoRepository contactInfoRepository;
    @Autowired
    IMapClassWithDto<User_contactInfo, ContactInfoModel> contactInfoMapping;


    @Autowired
    public ContactInfoService(IContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @GetMapping
    public List<ContactInfoModel> getContactInfo() {
        List<User_contactInfo> contactInfoListList = contactInfoRepository.findAll();
        return contactInfoMapping.convertListToListDto(contactInfoListList, ContactInfoModel.class);
    }


    public void addNewContact(User_contactInfo user_contactInfo) {
        Optional<User_contactInfo> contactInfoOptional = contactInfoRepository.findContactInfoByEmail(user_contactInfo.getEmail());

        if(contactInfoOptional.isPresent()) {
            throw new IllegalStateException("This email " + user_contactInfo.getEmail() + " is already taken");
        }

        contactInfoRepository.save(user_contactInfo);
    }
}
