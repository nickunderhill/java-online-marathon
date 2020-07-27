package com.softserve.edu.sprint02.task2;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestResults {


    public static void main(String[] args) {

        List<Caffee> originList = new java.util.ArrayList<>(Collections.emptyList());

        originList.add(new Espresso("Espresso", 8));
        originList.add(new Cappuccino("Cappuccino", 10));
        originList.add(new Espresso().setRating(10));
        originList.add(new Cappuccino().setRating(6));
        originList.add(new Caffee().setRating(6));

        for (Caffee drink : originList
        ) {
            System.out.print("Drink name: " + drink.getName());
            System.out.print(", Receipt: " + drink.getIngredients().toString());
            System.out.print(", Rating: " + drink.getRating() + "\n");
        }

        System.out.println();

        MyUtils rate = new MyUtils();
        Map<String, Double> averageRating = rate.averageRating(originList);
        System.out.println(averageRating.toString());
    }
}

