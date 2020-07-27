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
        ab.forEach(System.out::println);

        System.out.println("--DELETE");
        ab.delete("Steven", "Taylor");
        ab.forEach(System.out::println);

        System.out.println("--Update");
        ab.update("Bob", "Davis", "Address #125");
        ab.forEach(System.out::println);

        System.out.println("--Sort ASC");
        ab.sortedBy(SortOrder.ASC);
        ab.forEach(System.out::println);

        System.out.println("--Sort DESC");
        ab.sortedBy(SortOrder.DESC);
        ab.forEach(System.out::println);










//        ab.forEach(System.out::println);


    }

}
