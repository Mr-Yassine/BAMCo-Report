package com.youcode.BAMCoReport.Repositories;


import com.youcode.BAMCoReport.Entities.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContactInfoRepository extends JpaRepository<UserContactInfo, Long> {
    Optional<UserContactInfo> findContactInfoByEmail (String email);
}
