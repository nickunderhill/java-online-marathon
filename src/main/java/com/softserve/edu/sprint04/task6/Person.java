package com.softserve.edu.sprint04.task6;

import java.util.Arrays;
import java.util.Comparator;


enum Level {
    JUNIOR,
    MIDDLE,
    SENIOR
}

class Person {
    protected String name;
    protected int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private final double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private final Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.age - o2.age;
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        } else if (o1.getName().equals(o2.getName()) && o1.age != o2.age) {
            return o1.age - o2.age;
        }
        return (int) o1.getSalary() - (int) o2.getSalary();
    }
}

class DeveloperComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        } else if (o1.getName().equals(o2.getName()) && o1.age != o2.age) {
            return o1.age - o2.age;
        } else if (o1.getName().equals(o2.getName()) && o1.age == o2.age && !(o1.getLevel().equals(o2.getLevel()))) {
            return o1.getLevel().compareTo(o2.getLevel());
        }
        return (int) o1.getSalary() - (int) o2.getSalary();
    }
}

class Utility {

    public static <T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}