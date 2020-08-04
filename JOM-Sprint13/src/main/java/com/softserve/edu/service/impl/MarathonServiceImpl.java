package com.softserve.edu.service.impl;


import com.softserve.edu.exception.AbsentIdException;
import com.softserve.edu.model.Marathon;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.service.MarathonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonServiceImpl implements MarathonService {


    private final MarathonRepository marathonRepository;

    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<Marathon> getAll() {
        List<Marathon> marathons = marathonRepository.findAll();
        return !marathons.isEmpty() ? marathons : new ArrayList<>();
    }

    @Override
    public Marathon getMarathonById(Long id) {
        Optional<Marathon> marathon = marathonRepository.getById(id);
        if (marathon.isPresent()) {
            return marathon.get();
        } else {
            throw new AbsentIdException(id);
        }
    }

    @Override
    @Transactional
    public Marathon createOrUpdate(Marathon marathon) {
        marathonValidator(marathon);
        if (marathon.getId() != null) {
            Optional<Marathon> m = marathonRepository.getById(marathon.getId());
            if (m.isPresent()) {
                Marathon newMarathon = m.get();
                newMarathon.setTitle(marathon.getTitle());
                newMarathon.setUsers(marathon.getUsers());
                return marathonRepository.save(newMarathon);
            }
        }
        return marathonRepository.save(marathon);
    }

    @Override
    public void deleteMarathonById(Long id) {
        Optional<Marathon> marathon = marathonRepository.getById(id);
        if (marathon.isPresent()) {
            marathonRepository.deleteById(id);
        } else {
            throw new AbsentIdException(id);
        }
    }

    void marathonValidator(Marathon marathon) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Marathon>> violations = validator.validate(marathon);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }
    }
}
