package com.youcode.BAMCoReport.Repositories;

import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Entities.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IMembershipRepository extends JpaRepository<UserMembership, Long> {

    Optional<UserMembership> findMembershipById(Long id);
    UserMembership findByUserId(User id);
}
