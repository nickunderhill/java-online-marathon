package com.softserve.edu.sprint04.task4;

public class ArrayUtil {

    public static <T> T setAndReturn(T[] arr, T value, int position) {
        arr[position] = value;
        return arr[position];
    }

    //Test
    public static void main(String[] args) {
        String[] words = new String[3];
        String wordFromSecondPosition = ArrayUtil.setAndReturn(words, "Hello", 1);
        System.out.println(wordFromSecondPosition);

        Integer[] numbers = new Integer[3];
        Integer numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(numberFromSecondPosition);
    }
}
