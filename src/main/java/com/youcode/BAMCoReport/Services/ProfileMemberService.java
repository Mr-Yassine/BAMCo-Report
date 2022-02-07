package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.ProfileMemberDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.ProfileMember;
import com.youcode.BAMCoReport.Repositories.IProfileMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileMemberService {

    private final IProfileMemberRepository profileMemberRepository;

    @Autowired
    IMapClassWithDto<ProfileMember, ProfileMemberDTO> profileMemberMapping;

    public ProfileMemberService(IProfileMemberRepository profileMemberRepository) {
        this.profileMemberRepository = profileMemberRepository;
    }



    //get method
    public List<ProfileMemberDTO> getProfileMembers() {
        List<ProfileMember> profileMembersList = profileMemberRepository.findAll();
        return profileMemberMapping.convertListToListDto(profileMembersList, ProfileMemberDTO.class);
    }



    //add method
    public void addNewProfileMember(ProfileMember profileMember) {
        Optional<ProfileMember> profileMemberOptional = profileMemberRepository.findProfileMemberById(profileMember.getId());

        if(profileMemberOptional.isPresent()) {
            throw new IllegalStateException("This id " + profileMember.getId() + " is already taken");
        }

        profileMemberRepository.save(profileMember);
    }


    //delete method
    public void deleteProfileMember(Long id) {
        boolean exists = profileMemberRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Membership with id " + id + " does not exists");
        }
        profileMemberRepository.deleteById(id);
    }


}
