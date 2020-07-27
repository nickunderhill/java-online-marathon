package com.softserve.edu.sprint05.task3;

public class TestResult {
    //Test
    public static void main(String[] args) throws Exception {
        Plant p1 = Plant.tryCreatePlant("Rare", "Blue", "plant1");
        Plant p2 = Plant.tryCreatePlant("Unknown type", "Blue", "plant2");
        Plant p3 = Plant.tryCreatePlant("Rare", "Unknown color", "plant3");
        Plant p4 = Plant.tryCreatePlant("Unknown type", "Unknown color", "plant4");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());

    }
}
