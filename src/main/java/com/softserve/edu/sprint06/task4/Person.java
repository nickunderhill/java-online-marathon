package com.softserve.edu.sprint06.task4;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface DecisionMethod<T, T1> {
    boolean decide(String s, int i);
}

class Person {

    String name;
    String product = "product1";
    int discount = 10;
    public DecisionMethod<String, Integer> goShopping = (p, d) -> {
        return product.equals(p) && d > discount;
    };

    Person(String name) {
        this.name = name;
    }
}

class Shop {
    public List<DecisionMethod<String, Integer>> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        final int[] count = {0};
        clients.forEach(c -> {
            if (c.decide(product, percent)) {
                count[0]++;
            }
        });
        return count[0];
    }
}