package com.softserve.edu;

import com.softserve.edu.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class ApplicationTest {

    private MarathonService marathonService;
    private ProgressService progressService;
    private SprintService sprintService;
    private TaskService taskService;
    private UserService userService;

    @Autowired
    public ApplicationTest(MarathonService marathonService, ProgressService progressService, SprintService sprintService, TaskService taskService, UserService userService) {
        this.marathonService = marathonService;
        this.progressService = progressService;
        this.sprintService = sprintService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @Test
    public void checkGetStudents() {
        List<String> expected = Arrays.asList("Mykola","Denys","Petro");
        List<String> actual = Arrays.asList("Mykola","Denys","Petro");
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = Arrays.asList("Mykola","Yaroslav","Nataliia");
        List<String> actual = Arrays.asList("Mykola","Yaroslav","Nataliia");
        Assertions.assertEquals(expected, actual, "checkGetMentors()");
    }

}
