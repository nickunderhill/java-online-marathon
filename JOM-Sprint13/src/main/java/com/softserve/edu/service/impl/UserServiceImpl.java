package com.softserve.edu.service.impl;

import com.softserve.edu.exception.IncorrectEntityIdException;
import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.User;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.UserService;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MarathonRepository marathonRepository;

    public UserServiceImpl(UserRepository userRepository, MarathonRepository marathonRepository) {
        this.userRepository = userRepository;
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return !users.isEmpty() ? users : new ArrayList<>();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.getById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IncorrectEntityIdException("User with id " + id + " doesn't exist.");
        }
    }

    @Override
    @Transactional
    public User createOrUpdateUser(User entity) {
        userValidator(entity);
            Optional<User> user = userRepository.getById(entity.getId());
            if (user.isPresent()) {
                User newUser = user.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
                newUser.setRole(entity.getRole());
                newUser.setPassword(entity.getPassword());
                return userRepository.save(newUser);
            }
        return userRepository.save(entity);
    }

    @Override
    public List<User> getAllByRole(User.Role role) {
        List<User> roles = userRepository.getAllByRole(role);
        return !roles.isEmpty() ? roles : new ArrayList<>();
    }

    @Override
    @Transactional
    public boolean addUserToMarathon(User user, Marathon marathon) {
        userValidator(user);
        Optional<User> u = userRepository.getById(user.getId());
        Optional<Marathon> m = marathonRepository.getById(marathon.getId());
        if(u.isPresent() && m.isPresent()) {
            marathon.getUsers().add(user);
            user.getMarathons().add(marathon);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    void userValidator(User user) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty()){
            throw new RuntimeException(violations.toString());
        }
    }
}
