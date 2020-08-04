package com.softserve.edu.repository;

import com.softserve.edu.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    Optional<Sprint> getById(Long id);

    List<Sprint> getAllById(Long id);

    List<Sprint> getAllByMarathonId_Id(Long id);

}
