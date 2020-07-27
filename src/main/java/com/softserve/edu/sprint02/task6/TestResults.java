package com.softserve.edu.sprint02.task6;

import java.util.ArrayList;
import java.util.List;

public class TestResults {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle("Circle", 2));
        shapeList.add(new Rectangle("Rectangle", 2, 3));
        shapeList.add(new Circle("Circle", 1));
        shapeList.add(new Rectangle("Rectangle", 3, 2));
        shapeList.add(new Rectangle("Rectangle", 3, 2));
        shapeList.add(new Circle("Circle", 0.5));
        shapeList.add(new Rectangle("Rectangle", 1, 2));

        List<Shape> newShapeList = new MyUtils().maxAreas(shapeList);

    }
}
