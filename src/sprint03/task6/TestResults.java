package sprint03.task6;

import java.util.Iterator;

public class TestResults {

    public static void main(String[] args) {

        AddressBook ab = new AddressBook(5);
        ab.create("John", "Brown", "Address #1");
        ab.create("Karen", "Davis", "Address #2");
        ab.create("Steven", "Taylor", "Address #3");
        ab.create("Susan", "Brown", "Address #4");
        ab.create("John", "Taylor", "Address #4");
        ab.create("Bob", "Davis", "Address #4");

        System.out.println(ab.read("John", "Brown"));
        System.out.println(ab.read("Karen", "Davis"));
        System.out.println(ab.read("Steven", "Taylor"));
        System.out.println(ab.read("Susan", "Brown"));
        System.out.println(ab.read("John", "Taylor"));
        System.out.println(ab.read("Bob", "Davis"));

        System.out.println("===Delete");
        ab.delete("Steven", "Taylor");

        System.out.println(ab.read("John", "Brown"));
        System.out.println(ab.read("Karen", "Davis"));
        System.out.println(ab.read("Steven", "Taylor"));
        System.out.println(ab.read("Susan", "Brown"));
        System.out.println(ab.read("John", "Taylor"));
        System.out.println(ab.read("Bob", "Davis"));

        ab.forEach(System.out::println);
        ab.sortedBy(SortOrder.ASC);
        ab.forEach(System.out::println);









//        ab.forEach(System.out::println);


    }

}
