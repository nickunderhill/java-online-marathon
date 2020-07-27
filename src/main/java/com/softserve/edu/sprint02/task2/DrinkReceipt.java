package com.softserve.edu.sprint02.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private final Map<String, Integer> ingredients = new HashMap<>();
    // Code
    private String name;
    private int rating;

    public Caffee() {
        this.name = "Caffee";
        this.makeDrink();
    }

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.makeDrink();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        this.ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100)
                .addComponent("Arabica", 20);
        return this.ingredients;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    public Caffee setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}

class Espresso extends Caffee {
    public Espresso() {
        super();
        this.setName("Espresso");
    }

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        getIngredients().replace("Water", 50);
        return getIngredients();
    }
}

class Cappuccino extends Caffee {
    public Cappuccino() {
        super();
        this.setName("Cappuccino");
    }

    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        this.addComponent("Milk", 50);
        return getIngredients();
    }
}

class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        return coffees.stream()
                .collect(Collectors.groupingBy(Caffee::getName,
                        Collectors.averagingInt(Caffee::getRating)));
    }
}