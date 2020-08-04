package com.softserve.edu;

import com.softserve.edu.exception.AbsentIdException;
import com.softserve.edu.model.*;
import com.softserve.edu.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;

@SpringBootApplication
/*public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		}*/

//Todo remove debug
public class Application implements CommandLineRunner {

	UserService userService;
	ProgressService progressService;
	MarathonService marathonService;
	SprintService sprintService;
	TaskService taskService;

	public Application(UserService userService, ProgressService progressService, MarathonService marathonService, SprintService sprintService, TaskService taskService) {
		this.userService = userService;
		this.progressService = progressService;
		this.marathonService = marathonService;
		this.sprintService = sprintService;
		this.taskService = taskService;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(com.softserve.edu.Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Create users
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setFirstName("First_" + i);
			user.setLastName("Last_" + i);
			user.setPassword("1234qwer");
			user.setEmail("user" + i + "@email.com");
			if (i < 3) {
				user.setRole(User.Role.MENTOR);
			} else {
				user.setRole(User.Role.STUDENT);
			}
			userService.createOrUpdateUser(user);
		}

		//Create marathons
		Marathon marathon1 = new Marathon();
		marathon1.setTitle("Marathon #1");
		marathonService.createOrUpdate(marathon1);
		Marathon marathon2 = new Marathon();
		marathon2.setTitle("Marathon #2");
		marathonService.createOrUpdate(marathon2);

		//Create sprints
		Sprint sprint1 = new Sprint();
		sprint1.setTitle("Sprint #1");
		sprint1.setStartDate(LocalDate.now());
		sprintService.addSprintToMarathon(sprint1, marathon1);
		Sprint sprint2 = new Sprint();
		sprint2.setTitle("Sprint #2");
		sprint2.setStartDate(LocalDate.now());
		sprintService.addSprintToMarathon(sprint2, marathon1);

		//Create tasks
		Task task1 = new Task();
		task1.setTitle("Practice");
		task1.setCreated(LocalDate.now());
		task1 = taskService.addTaskToSprint(task1, sprintService.getSprintById(1L));
		Task task2 = new Task();
		task2.setTitle("Quiz");
		task2.setCreated(LocalDate.now());
		task2 = taskService.addTaskToSprint(task2, sprintService.getSprintById(1L));

		//Create Progress
		Progress progress1 = new Progress();
		progress1.setStatus(Progress.TaskStatus.PENDING);
		progress1.setTrainee(userService.getUserById(5L));
		progress1.setUpdated(LocalDate.now());
		progress1.setStarted(LocalDate.now());
		progress1.setTask(task1);
		progressService.addOrUpdateProgress(progress1);
		Progress progress2 = new Progress();
		progress2.setStatus(Progress.TaskStatus.PASS);
		progress2.setTrainee(userService.getUserById(6L));
		progress2.setUpdated(LocalDate.now());
		progress2.setStarted(LocalDate.now());
		progress2.setTask(task2);
		progressService.addOrUpdateProgress(progress2);

		//UserService Tests
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("-----UserService Tests-----");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("*** getAll Method: ***");
		System.out.println();
		System.out.println(userService.getAll().toString());
		System.out.println("*** getUserById Method: ***");
		System.out.println();
		System.out.println(userService.getUserById(5L).toString());
		System.out.println("*** createOrUpdateUser Method: ***");
		System.out.println();
		System.out.println("Before: " + userService.getUserById(5L).toString());
		User user = new User();
		user.setId(5L);
		user.setFirstName("Renamed");
		user.setLastName("New");
		user.setPassword("password");
		user.setEmail("new_user@email.com");
		user.setRole(User.Role.MENTOR);
		userService.createOrUpdateUser(user);
		System.out.println("After: " + userService.getUserById(5L).toString());
		System.out.println();
		System.out.println("*** getAllByRole Method: ***");
		System.out.println();
		System.out.println(userService.getAllByRole(User.Role.MENTOR).toString());
		System.out.println();
		System.out.println("*** addUserToMarathon Method: ***");
		System.out.println();
		System.out.println(userService.addUserToMarathon(userService.getUserById(1L), marathonService.getMarathonById(1L)));
		System.out.println(userService.addUserToMarathon(userService.getUserById(2L), marathonService.getMarathonById(1L)));
		System.out.println(userService.addUserToMarathon(userService.getUserById(3L), marathonService.getMarathonById(1L)));
		System.out.println(userService.addUserToMarathon(userService.getUserById(4L), marathonService.getMarathonById(1L)));
		System.out.println(userService.addUserToMarathon(userService.getUserById(5L), marathonService.getMarathonById(1L)));

		//ProgressService Tests
		System.out.println("-------------------------------");
		System.out.println("-----ProgressService Tests-----");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("*** getProgressById Method: ***");
		System.out.println();
		System.out.println(progressService.getProgressById(progress1.getId()).toString());
		System.out.println();
		System.out.println("*** addTaskForStudent Method: ***");
		System.out.println();
		System.out.println(progressService.addTaskForStudent(task2, user).toString());
		System.out.println("*** addOrUpdateProgress Method: ***");
		System.out.println();
		System.out.println("Before: " + progressService.getProgressById(5L).toString());
		Progress updateProgress = progressService.getProgressById(5L);
		updateProgress.setTask(task1);
		updateProgress.setStatus(Progress.TaskStatus.PASS);
		progressService.addOrUpdateProgress(updateProgress);
		System.out.println("After: " + progressService.getProgressById(progress1.getId()).toString());
		System.out.println("*** setStatus Method: ***");
		System.out.println();
		System.out.println("Before: " + progressService.getProgressById(progress1.getId()).toString());
		progressService.setStatus(Progress.TaskStatus.PASS, progress1);
		System.out.println("After: " + progressService.getProgressById(progress1.getId()).toString());
		System.out.println("*** allProgressByUserIdAndMarathonId Method: ***");
		progressService.setStatus(Progress.TaskStatus.PASS, progress1);
		System.out.println(progressService.allProgressByUserIdAndMarathonId(5L, 1L).toString());
		System.out.println();
		System.out.println("*** allProgressByUserIdAndSprintId Method: ***");
		progressService.setStatus(Progress.TaskStatus.PASS, progress1);
		System.out.println(progressService.allProgressByUserIdAndSprintId(6L,1L).toString());
		System.out.println();

		//TaskService Tests
		System.out.println("---------------------------");
		System.out.println("-----TaskService Tests-----");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("*** addTaskToSprint Method: ***");
		System.out.println();
		Task newTask = new Task();
		newTask.setTitle("Exam");
		System.out.println(taskService.addTaskToSprint(newTask, sprintService.getSprintById(2L)));
		System.out.println();
		System.out.println("*** getTaskById Method: ***");
		System.out.println();
		System.out.println(taskService.getTaskById(1L));
		System.out.println();

		//SprintService Tests
		System.out.println("-----------------------------");
		System.out.println("-----SprintService Tests-----");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("*** getSprintsByMarathonId Method: ***");
		System.out.println();
		System.out.println(sprintService.getSprintsByMarathonId(1L).toString());
		System.out.println();
		System.out.println("*** addSprintToMarathon Method: ***");
		Sprint newSprint = new Sprint();
		newSprint.setTitle("Sprint #3");
		newSprint.setStartDate(LocalDate.now());
		newSprint = sprintService.addSprintToMarathon(newSprint, marathon2);
		System.out.println(sprintService.getSprintById(newSprint.getId()).toString());

		System.out.println("*** getSprintById Method: ***");
		System.out.println(sprintService.getSprintById(1L));
		System.out.println("*** updateSprint Method: ***");
		System.out.println("Before: " + sprintService.getSprintById(newSprint.getId()));
		newSprint.setTitle("Sprint #3 - Finished");
		sprintService.updateSprint(newSprint);
		System.out.println("After: " + sprintService.getSprintById(newSprint.getId()));

		//MarathonService Tests
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("-----MarathonService Tests-----");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("*** getAll() test ***");
		System.out.println(marathonService.getAll().toString());
		System.out.println("*** createOrUpdate() test ***");
		Marathon marathon3 = new Marathon();
		marathon3.setTitle("Marathon #3");
		marathonService.createOrUpdate(marathon3);
		Marathon newMarathon = new Marathon();
		newMarathon.setTitle("Anime Marathon");
		newMarathon.setUsers(new HashSet<User>());
		System.out.println(marathonService.createOrUpdate(newMarathon));
		System.out.println("*** getMarathonId() test ***");
		System.out.println(marathonService.getMarathonById(marathon3.getId()).toString());
		System.out.println(marathonService.getMarathonById(newMarathon.getId()).toString());
		System.out.println("*** deleteMarathonById() test ***");
		marathonService.deleteMarathonById(marathon3.getId());
		try {
			marathonService.deleteMarathonById(20L);
		} catch (AbsentIdException e) {
			System.out.println(e.getMessage());
		}

	}
}