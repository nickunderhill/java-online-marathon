package com.softserve.edu.repository;

import com.softserve.edu.model.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {
    List<Marathon> getAllById(Marathon id);

    Optional<Marathon> getById(Long id);
}
