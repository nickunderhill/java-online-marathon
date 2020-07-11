package sprint09.task1;

import java.time.LocalDate;

public class App {
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear();
    }

    //Test
    public static void main(String[] args) {
        System.out.println(isLeapYear(1000));
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2014));
        System.out.println(isLeapYear(2016));
    }
}
