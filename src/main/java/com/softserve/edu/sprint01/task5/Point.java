package com.softserve.edu.sprint01.task5;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //debug
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(7, 1);

        System.out.println(p1.distance(7, 1));
        System.out.println(p2.distance(p1));
        System.out.println(p1.distance());
        System.out.println(p2.distance());
    }

    public int[] getXYPair() {
        return new int[]{x, y};
    }

    public double distance(int x, int y) {
        return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));

    }

    public double distance(Point point) {
        return Math.sqrt((point.y - this.y) * (point.y - this.y) + (point.x - this.x) * (point.x - this.x));

    }

    public double distance() {
        double origin = 0;
        return Math.sqrt((origin - this.y) * (origin - this.y) + (origin - this.x) * (origin - this.x));

    }
}
