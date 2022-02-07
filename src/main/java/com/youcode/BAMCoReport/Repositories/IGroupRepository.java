package com.youcode.BAMCoReport.Repositories;

import com.youcode.BAMCoReport.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IGroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findGroupByName(String name);
}
