package com.softserve.edu.sprint06.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class App {

    static BinaryOperator<String> greetingOperator = (s1, s2) -> "Hello " + s1 + " " + s2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> b) {

        List<String> result = new ArrayList<>();
        for (Person p : people) {
            result.add(b.apply(p.name, p.surname));
        }

        return result;
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", "White"));
        personList.add(new Person("Jack", "Black"));
        personList.add(new Person("Nick", "Grey"));

        createGreetings(personList, greetingOperator).stream().forEach(System.out::println);

    }
}