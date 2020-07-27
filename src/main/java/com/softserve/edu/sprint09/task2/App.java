package com.softserve.edu.sprint09.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate date = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    //Test
    public static void main(String[] args) {

        System.out.println(getDateAfterToday(3, 18, 27));

    }
}
