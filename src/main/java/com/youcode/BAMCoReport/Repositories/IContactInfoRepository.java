package com.youcode.BAMCoReport.Repositories;


import com.youcode.BAMCoReport.Entities.User_contactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IContactInfoRepository extends JpaRepository<User_contactInfo, Long> {
    Optional<User_contactInfo> findContactInfoByEmail (String email);
}
