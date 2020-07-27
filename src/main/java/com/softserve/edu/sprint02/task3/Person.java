package com.softserve.edu.sprint02.task3;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends Person {
    private final String studyPlace;
    private final int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }
}

class Worker extends Person {
    private final String workPosition;
    private final int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Person> result = new java.util.ArrayList<Person>(Collections.emptyList());
        List<Worker> workers = new java.util.ArrayList<Worker>(Collections.emptyList());
        List<Student> students = new java.util.ArrayList<Student>(Collections.emptyList());

        if (persons.isEmpty() || persons == null) {
            return result;
        }

        for (Person p : persons) {
            if (p == null) {
                return result;
            }

            if (p instanceof Student) {
                students.add((Student) p);
            }
            if (p instanceof Worker) {
                workers.add((Worker) p);
            }
        }
        int maxDurationStudent;
        int maxDurationWorker;

        try {
            maxDurationStudent = students
                    .stream()
                    .max(Comparator.comparing(Student::getStudyYears))
                    .get().getStudyYears();
            maxDurationWorker = workers
                    .stream()
                    .max(Comparator.comparing(Worker::getExperienceYears))
                    .get().getExperienceYears();
        } catch (NoSuchElementException exception) {
            return result;
        }

        for (Person p : persons) {
            if (p instanceof Student && ((Student) p).getStudyYears() == maxDurationStudent) {
                result.add(p);
            }
            if (p instanceof Worker && ((Worker) p).getExperienceYears() == maxDurationWorker) {
                result.add(p);
            }
        }

        List<Person> distinctPersons = result.stream().distinct().collect(Collectors.toList());
        result = distinctPersons;

        return result;
    }
}