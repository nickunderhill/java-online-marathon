package com.softserve.edu.sprint03.task4;

class App4 {

    public static String drawLine(LineType lineType) {
        return "The line is "
                + lineType.toString().toLowerCase()
                + " type";
    }

    public static void main(String[] args) {
        LineType line = LineType.SOLID;
        System.out.println(drawLine(line));
    }

    enum LineType {
        SOLID,
        DOTTED,
        DASHED,
        DOUBLE
    }
}