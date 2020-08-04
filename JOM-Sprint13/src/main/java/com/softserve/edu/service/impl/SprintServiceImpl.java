package com.softserve.edu.service.impl;

import com.softserve.edu.exception.IncorrectEntityIdException;
import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.Sprint;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.repository.SprintRepository;
import com.softserve.edu.service.SprintService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;
    private final MarathonRepository marathonRepository;

    public SprintServiceImpl(SprintRepository sprintRepository, MarathonRepository marathonRepository) {
        this.sprintRepository = sprintRepository;
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<Sprint> getSprintsByMarathonId(Long id) {
        Optional<Marathon> marathon = marathonRepository.getById(id);
        if (marathon.isPresent()) {
            return sprintRepository.getAllByMarathonId_Id(id);
        } else {
            throw new IncorrectEntityIdException("Marathon with id " + id + " doesn't exist.");
        }
    }

    @Override
    @Transactional
    public Sprint addSprintToMarathon(Sprint sprint, Marathon marathon) {
        Optional<Marathon> m = marathonRepository.getById(marathon.getId());
        if (m.isPresent()) {
            Sprint newSprint = new Sprint();
            newSprint.setStartDate(LocalDate.now());
            newSprint.setTitle(sprint.getTitle());
            newSprint.setMarathon(m.get());
            sprintRepository.save(newSprint);
            return newSprint;
        }
        throw new IncorrectEntityIdException("Marathon with id " + marathon.getId() + "doesn't exist");
    }

    @Override
    @Transactional
    public boolean updateSprint(Sprint entity) {
        sprintValidator(entity);
        Optional<Sprint> sprint = sprintRepository.getById(entity.getId());
        if (sprint.isPresent()) {
            Sprint s = sprint.get();
            s.setTitle(entity.getTitle());
            s.setFinish(LocalDate.now());
            sprintRepository.save(s);
            return true;
        }
        throw new IncorrectEntityIdException("Sprint with id " + entity.getId() + "doesn't exist");
    }

    @Override
    public Sprint getSprintById(Long id) {
        Optional<Sprint> sprint = sprintRepository.getById(id);
        if (sprint.isPresent()) {
            return sprint.get();
        } else {
            throw new IncorrectEntityIdException("Sprint with id " + id + " doesn't exist.");
        }
    }

    void sprintValidator(Sprint sprint) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Sprint>> violations = validator.validate(sprint);
        if(!violations.isEmpty()){
            throw new RuntimeException(violations.toString());
        }
    }
}
