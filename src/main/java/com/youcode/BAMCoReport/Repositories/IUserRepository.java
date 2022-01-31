package com.youcode.BAMCoReport.Repositories;


import com.youcode.BAMCoReport.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional <User> findUserByUsername(String username);
}

