package com.softserve.edu.sprint05.task3;

enum Color {
    WHITE, RED, BLUE
}

enum Type {
    RARE, ORDINARY
}

public class Plant {
    private final String name;
    private final Color color;
    private final Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException {
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypeException("Invalid value " + type + " for field type");
        }
        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ColorException("Invalid value " + color + " for field color");
        }
        this.name = name;
    }

    static Plant tryCreatePlant(String type, String color, String name) throws ColorException, TypeException {
        try {
            return new Plant(type, color, name);
        } catch (ColorException ex) {
            return tryCreatePlant(type, "Red", name);
        } catch (TypeException ex) {
            return tryCreatePlant("Ordinary", color, name);
        }
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{" +
                "type: " + type +
                ", color: " + color +
                ", name: " + name +
                '}';
    }
}

class ColorException extends Exception {

    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {

    public TypeException(String message) {
        super(message);
    }
}
