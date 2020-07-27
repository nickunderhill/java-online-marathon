package com.softserve.edu.sprint02.task5;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    public static void main(String[] args) {
        List<Figure> figureList = new ArrayList<>();
        figureList.add(new Square(4));
        figureList.add(new Square(5));
        figureList.add(new Rectang(2, 3));

        double perim = new MyUtils().sumPerimeter(figureList);
        System.out.println(perim);
    }
}
