package com.softserve.edu.sprint04.task6;

import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Person[] peopleArray = new Person[]{
                new Person("John", 40),
                new Person("John", 23),
                new Employee("Fred Worker", 25, 1000),
                new Employee("Emma Worker", 30, 1400),
                new Developer("Lucy Coder", 25, 1000, Level.JUNIOR),
                new Developer("James Coder", 31, 2000, Level.MIDDLE)
        };

        Employee[] employeeArray = new Employee[]{
                new Employee("Fred Worker", 25, 4000),
                new Employee("Fred Worker", 25, 1000),
                new Employee("Emma Worker", 30, 1400),
                new Developer("Lucy Coder", 25, 1000, Level.JUNIOR),
                new Developer("James Coder", 31, 2000, Level.MIDDLE)
        };

        Developer[] developerArray = new Developer[]{
                new Developer("Fred Worker", 25, 4000, Level.SENIOR),
                new Developer("Fred Worker", 25, 4000, Level.JUNIOR),
                new Developer("Emma Worker", 30, 1400, Level.JUNIOR),
                new Developer("Lucy Coder", 25, 1000, Level.JUNIOR),
                new Developer("James Coder", 31, 2000, Level.MIDDLE)
        };

        System.out.println("===Person Before:");
        for (Person p : peopleArray) {
            System.out.println("Name: " + p.name + ", Age: " + p.age);
        }

        Comparator<Person> pComp = new PersonComparator();

        Utility.sortPeople(peopleArray, pComp);

        System.out.println("===Person After:");
        for (Person p : peopleArray) {
            System.out.println("Name: " + p.name + ", Age: " + p.age);
        }

        System.out.println("===Employee Before:");
        for (Employee e : employeeArray) {
            System.out.println("Name: " + e.name + ", Age: " + e.age + ", Salary: " + e.getSalary());
        }

        Utility.sortPeople(employeeArray, new EmployeeComparator());

        System.out.println("===Employee After:");
        for (Employee e : employeeArray) {
            System.out.println("Name: " + e.name + ", Age: " + e.age + ", Salary: " + e.getSalary());
        }

        System.out.println("===Developer Before:");
        for (Developer d : developerArray) {
            System.out.println("Name: " + d.name + ", Age: " + d.age + ", Salary: " + d.getSalary() + ", Level: " + d.getLevel());
        }

        Utility.sortPeople(developerArray, new DeveloperComparator());

        System.out.println("===Developer After:");
        for (Developer d : developerArray) {
            System.out.println("Name: " + d.name + ", Age: " + d.age + ", Salary: " + d.getSalary() + ", Level: " + d.getLevel());
        }

        class StringComparator implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
                return -1;
            }
        }

        System.out.println("===String test:");
        String[] s = new String[]{"ca", "ab", "dc", "bd"};
    }
}
