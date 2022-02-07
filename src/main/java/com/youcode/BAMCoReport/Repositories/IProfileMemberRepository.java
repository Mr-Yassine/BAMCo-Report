package com.youcode.BAMCoReport.Repositories;

import com.youcode.BAMCoReport.Entities.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IProfileMemberRepository extends JpaRepository<ProfileMember, Long> {
    Optional <ProfileMember> findProfileMemberById (Long id);
}
