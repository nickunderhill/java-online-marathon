package com.softserve.edu.sprint02.task6;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

abstract class Shape {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract double getArea();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(getName(), shape.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private final double height;
    private final double witdth;

    public Rectangle(String name, double height, double witdth) {
        super(name);
        this.height = height;
        this.witdth = witdth;
    }

    public double getArea() {
        return witdth * height;
    }

    public double getHeight() {
        return height;
    }

    public double getWitdth() {
        return witdth;
    }

}

class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> circles = new java.util.ArrayList<Shape>();
        List<Shape> rectangles = new java.util.ArrayList<Shape>();
        List<Shape> result = new java.util.ArrayList<Shape>();
        double maxCircleArea;
        double maxRectangleArea;

        if (shapes.isEmpty() || shapes.size() == 1) {
            return shapes;
        }

        for (Shape s : shapes) {
            if (s == null) {
                return result;
            }

            if (s instanceof Circle) {
                circles.add(s);
            }
            if (s instanceof Rectangle) {
                rectangles.add(s);
            }
        }

        try {
            maxCircleArea = circles
                    .stream()
                    .max(Comparator.comparing(Shape::getArea))
                    .get().getArea();
            System.out.println(maxCircleArea);
            maxRectangleArea = rectangles
                    .stream()
                    .max(Comparator.comparing(Shape::getArea))
                    .get().getArea();
            System.out.println(maxRectangleArea);
        } catch (NoSuchElementException exception) {
            return result;
        }

        for (Shape s : shapes) {
            if (s instanceof Circle && s.getArea() == maxCircleArea) {
                result.add(s);
            }
            if (s instanceof Rectangle && s.getArea() == maxRectangleArea) {
                result.add(s);
            }
        }

        List<Shape> distinctShapes = result.stream().distinct().collect(Collectors.toList());
        result = distinctShapes;

        return result;
    }
}
