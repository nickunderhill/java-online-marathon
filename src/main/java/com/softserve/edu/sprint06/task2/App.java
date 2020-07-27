package com.softserve.edu.sprint06.task2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class App {
    static double threshold = 2.0;
    static double underThresholdCoef = 0.8;
    static double overThresholdCoef = 0.9;

    static Consumer<double[]> cons = (double[] d) -> {
        IntStream.range(0, d.length).forEach(i -> {
            d[i] *= d[i] > threshold ? underThresholdCoef : overThresholdCoef;
        });
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> c) {
        double[] result = initialArray.clone();
        c.accept(result);
        return result;
    }

    //Test
    public static void main(String[] args) {
        double[] oldArr = {1.0, 1.5, 2.5, 3.5};
        double[] newArr;
        newArr = getChanged(oldArr, cons);
        Arrays.stream(oldArr).forEach(System.out::println);
        Arrays.stream(newArr).forEach(System.out::println);

    }
}