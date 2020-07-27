package sprint02.task3;

import java.util.*;

public class TestResults {
    public static void main(String[] args) {

        List<Person> persons = new java.util.ArrayList<>(Collections.emptyList());

        persons.add(new Person("Ivan"));
        persons.add(new Student("Petro", "University", 3));
        persons.add(new Worker("Andriy", "Developer", 12));
        persons.add(new Student("Stepan", "College", 4));
        persons.add(new Worker("Ira", "Manager", 8));
        persons.add(new Student("Ihor", "University", 4));

        List<Person> persons2 = new java.util.ArrayList<>(Collections.emptyList());

        List<Person> persons3 = new java.util.ArrayList<>(Collections.emptyList());

        persons3.add(new Person("Ivan"));
        persons3.add(new Worker("Andriy", "Developer", 12));
        persons3.add(new Student("Stepan", "College", 4));
        persons3.add(new Worker("Ira", "Manager", 8));
        persons3.add(new Student("Ihor", "University", 4));

        List<Person> persons4 = new java.util.ArrayList<>(Collections.emptyList());
        persons4.add(new Person("Ivan"));
        persons4.add(new Worker("Andriy", "Developer", 12));
        persons4.add(new Student("Stepan", "College", 4));
        persons4.add(new Worker("Ira", "Manager", 8));
        persons4.add(new Student("Ihor", "University", 4));
        persons4.add(new Student("Ihor", "University", 4));

        List<Person> persons5 = new java.util.ArrayList<>(Collections.emptyList());

        persons5.add(new Person("Ivan"));
        persons5.add(null);
        persons5.add(new Worker("Andriy", "Developer", 12));
        persons5.add(new Student("Stepan", "College", 4));
        persons5.add(new Worker("Ira", "Manager", 8));
        persons5.add(new Student("Ihor", "University", 4));

        List<Person> persons6 = new java.util.ArrayList<>(Collections.emptyList());

        persons6.add(new Person("Ivan"));

        MyUtils test = new MyUtils();

        System.out.println("============Test 1 Unique persons==================");

        persons = test.maxDuration(persons);

        for (Person elem : persons) {
            System.out.println(elem.getName());
        }

        System.out.println("============Test 2 Empty array==================");

        persons2 = test.maxDuration(persons2);

        for (Person elem : persons2) {
            System.out.println(elem.getName());
        }

        System.out.println("===========Test 3 duplicated year===================");
        persons3 = test.maxDuration(persons3);

        for (Person elem : persons3) {
            System.out.println(elem.getName());
        }

        System.out.println("===========Test 4 duplicated both===================");
        persons4 = test.maxDuration(persons4);

        for (Person elem : persons4) {
            System.out.println(elem.getName());
        }

        System.out.println("===========Test 5 null object in List===================");
        persons5 = test.maxDuration(persons5);

        for (Person elem : persons5) {
            System.out.println(elem.getName());
        }

        System.out.println("===========Test 6 one person===================");
        persons6 = test.maxDuration(persons6);

        for (Person elem : persons6) {
            System.out.println(elem.getName());
        }
    }
}