package com.youcode.BAMCoReport.Repositories;


import com.youcode.BAMCoReport.Entities.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IContactInfoRepository extends JpaRepository<UserContactInfo, Long> {
    Optional<UserContactInfo> findContactInfoByEmail (String email);
}
