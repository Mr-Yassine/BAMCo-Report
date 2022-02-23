package com.youcode.BAMCoReport.Repositories;

import com.youcode.BAMCoReport.Entities.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRejectRepository extends JpaRepository<Reject, Long> {

    Optional<Reject> findRejectById(Long id);

}
