package com.softserve.edu.service.impl;

import com.softserve.edu.exception.IncorrectEntityIdException;
import com.softserve.edu.model.Progress;
import com.softserve.edu.model.Sprint;
import com.softserve.edu.model.Task;
import com.softserve.edu.model.User;
import com.softserve.edu.repository.ProgressRepository;
import com.softserve.edu.repository.SprintRepository;
import com.softserve.edu.repository.TaskRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.ProgressService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final SprintRepository sprintRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository,
                               UserRepository userRepository,
                               SprintRepository sprintRepository) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Progress getProgressById(Long id) {
        Optional<Progress> progress = progressRepository.getById(id);
        if (progress.isPresent()) {
            return progress.get();
        } else {
            throw new IncorrectEntityIdException("Progress with id " + id + " doesn't exist.");
        }
    }

    @Override
    @Transactional
    public Progress addTaskForStudent(Task task, User user) {
        if (!progressRepository.findByTraineeAndTask(user, task).isPresent()) {
            Progress entity = new Progress();
            entity.setTrainee(userRepository.getOne(user.getId()));
            entity.setTask(task);
            entity.setStatus(Progress.TaskStatus.PENDING);
            entity.setStarted(LocalDate.now());
            return progressRepository.save(entity);
        }
        throw new IncorrectEntityIdException("Progress with task id " + task.getId() + " and user id " + user.getId() + "already exists");

    }

    @Override
    @Transactional
    public Progress addOrUpdateProgress(Progress entity) {
        progressValidator(entity);
        if (entity.getId() != null) {
            Optional<Progress> progress = progressRepository.getById(entity.getId());
            if (progress.isPresent()) {
                Progress newProgress = progress.get();
                newProgress.setStatus(entity.getStatus());
                newProgress.setUpdated(LocalDate.now());
                newProgress.setTask(entity.getTask());
                newProgress.setTrainee(entity.getTrainee());
                return progressRepository.save(newProgress);
            }
        }
        return progressRepository.save(entity);
    }

    @Override
    @Transactional
    public boolean setStatus(Progress.TaskStatus status, Progress entity) {
        progressValidator(entity);
        if (entity.getId() != null) {
            entity.setStatus(status);
            entity.setUpdated(LocalDate.now());
            progressRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId) {
        return progressRepository.findByUserIdAndMarathonId(userId, marathonId);
    }

    @Override
    public List<Progress> allProgressByUserIdAndSprintId(Long userId, Long sprintId) {
        Optional<User> user = userRepository.getById(userId);
        Optional<Sprint> sprint = sprintRepository.findById(sprintId);
        if(user.isPresent() && sprint.isPresent()) {
            return progressRepository.findByTraineeAndTask_Sprint(user.get(), sprint.get());
        }
        return new ArrayList<>();
    }

    void progressValidator(Progress progress) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Progress>> violations = validator.validate(progress);
        if(!violations.isEmpty()){
            throw new RuntimeException(violations.toString());
        }
    }
}
