package com.softserve.edu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Sprint {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(columnDefinition = "DATE")
    private LocalDate finish;

    @NotNull
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marathon_id")
    private Marathon marathon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="sprint")
    private List<Task> taskList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Marathon getMarathon() {
        return marathon;
    }

    public void setMarathon(Marathon marathon) {
        this.marathon = marathon;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", finish=" + finish +
                ", startDate=" + startDate +
                ", title='" + title + '\'' +
                ", marathonId=" + marathon.getId() +
                '}' + '\n' ;
    }
}
