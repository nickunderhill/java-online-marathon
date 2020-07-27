package com.softserve.edu.sprint08.task1;

import java.util.function.BinaryOperator;

public class TestResults {
    public static void main(String[] args) {
        BinaryOperator<Integer> func = Integer::sum;
        Thread MyThread = new Thread(new ParallelCalculator(func, 5, 10));
        MyThread.start();
    }
}
