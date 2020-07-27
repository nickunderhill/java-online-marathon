package com.softserve.edu.sprint09.task7;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public static void main(String[] args) {
        MyUtils m = new MyUtils();
        m.duplicateElements(Stream.of(-3, -2, 1, 1, 12, -3, 8, 2, 4))
                .forEach(System.out::println);
    }

    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        List<Integer> intList = stream
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return intList.stream()
                .filter(i -> Collections.frequency(intList, i) > 1)
                .collect(Collectors.toSet()).stream()
                .sorted();
    }
}
