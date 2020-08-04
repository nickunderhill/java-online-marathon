package com.softserve.edu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Progress {

    public enum TaskStatus {
        PASS,
        FAIL,
        PENDING
    }

    @Id
    @GeneratedValue()
    private Long id;

    @Column(columnDefinition = "DATE")
    @NotNull
    private LocalDate started;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TaskStatus status;

    @Column(columnDefinition = "DATE")
    private LocalDate updated;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "trainee_id")
    private User trainee;

    public Progress() {
    }

    public Progress(LocalDate started, TaskStatus status, LocalDate updated, Task task, User trainee) {
        this.started = started;
        this.status = status;
        this.updated = updated;
        this.task = task;
        this.trainee = trainee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getTrainee() {
        return trainee;
    }

    public void setTrainee(User trainee) {
        this.trainee = trainee;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", started=" + started +
                ", status=" + status +
                ", updated=" + updated +
                ", trainee=" + trainee.getId() +
                ", task=" + task.getId() +
                '}' + '\n' ;
    }
}


