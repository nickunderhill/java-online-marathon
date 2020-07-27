package com.softserve.edu.sprint06.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        return numbers.stream().filter(pr).max(Integer::compare).get();
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> func, Predicate<Integer> predicate) {
        return func.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}