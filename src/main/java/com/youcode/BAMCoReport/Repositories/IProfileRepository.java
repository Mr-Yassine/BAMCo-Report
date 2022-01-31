package com.youcode.BAMCoReport.Repositories;

import com.youcode.BAMCoReport.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Optional <Profile> findProfileByName (String name);
}
