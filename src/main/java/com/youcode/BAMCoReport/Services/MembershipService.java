package com.youcode.BAMCoReport.Services;

import com.youcode.BAMCoReport.DTO.Models.MembershipDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Entities.UserMembership;
import com.youcode.BAMCoReport.Repositories.IMembershipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class MembershipService {

    private final IMembershipRepository membershipRepository;


    @Autowired
    IMapClassWithDto<UserMembership, MembershipDTO> membershipMapping;


    @Autowired
    public MembershipService(IMembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }


    //get method
    public List<MembershipDTO> getMembership() {
        List<UserMembership> membershipList = membershipRepository.findAll();
        System.out.println("list" + membershipList);
        return membershipMapping.convertListToListDto(membershipList, MembershipDTO.class);
    }
    public UserMembership getMembershipBy(Long id) {
        return membershipRepository.findMembershipById(id).orElse(null);
    }



    //add method
    public void addNewMembership(UserMembership membership) {
        Optional<UserMembership> membershipOptional = membershipRepository.findMembershipById(membership.getId());

        if(membershipOptional.isPresent()) {
            throw new IllegalStateException("This id " + membership.getId() + " is already taken");
        }

        log.info("Membership added successfully");
        membershipRepository.save(membership);
    }


    //delete method
    public void deleteMembership(Long id) {
        boolean exists = membershipRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Membership with id " + id + " does not exists");
        }
        log.info("Membership deleted successfully");
        membershipRepository.deleteById(id);
    }


}
