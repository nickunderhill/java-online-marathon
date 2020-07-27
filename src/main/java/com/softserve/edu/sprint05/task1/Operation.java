package com.softserve.edu.sprint05.task1;

public class Operation {
    public static int squareRectangle(int a, int b) {
        if (a < 1 || b < 1)
            throw new IllegalArgumentException("both arguments should be more than zero");
        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    //Test
    public static void main(String[] args) {
        System.out.println(squareRectangle(1, 2));
//        System.out.println(squareRectangle(1,-2));
        System.out.println(squareRectangle(-1, 2));
//        System.out.println(squareRectangle(-1,-12));

        System.out.println(trySquareRectangle(1, 2));
        System.out.println(trySquareRectangle(-1, 2));
        System.out.println(trySquareRectangle(1, 2));
        System.out.println(trySquareRectangle(-1, -2));
        System.out.println(trySquareRectangle(0, 5));
    }
}
