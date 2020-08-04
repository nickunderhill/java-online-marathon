package com.softserve.edu.service.impl;

import com.softserve.edu.exception.AbsentIdException;
import com.softserve.edu.exception.IncorrectEntityIdException;
import com.softserve.edu.model.Sprint;
import com.softserve.edu.model.Task;
import com.softserve.edu.repository.SprintRepository;
import com.softserve.edu.repository.TaskRepository;
import com.softserve.edu.service.TaskService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final SprintRepository sprintRepository;

    public TaskServiceImpl(TaskRepository taskRepository, SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.sprintRepository = sprintRepository;
    }

    @Override
    @Transactional
    public Task addTaskToSprint(Task task, Sprint inputSprint) {
        taskValidator(task);
            Optional<Sprint> sprint = sprintRepository.findById(inputSprint.getId());
            if (sprint.isPresent()) {
                Task t = new Task();
                t.setSprint(sprint.get());
                t.setTitle(task.getTitle());
                t.setCreated(LocalDate.now());
                taskRepository.save(t);
                return t;
            }
            throw new AbsentIdException(inputSprint.getId());
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.getById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new IncorrectEntityIdException("Task with id " + id + " doesn't exist.");
        }
    }

    void taskValidator(Task task) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }
    }
}
