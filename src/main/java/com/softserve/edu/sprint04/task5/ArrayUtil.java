package com.softserve.edu.sprint04.task5;

public class ArrayUtil {

    static <T extends Number> double averageValue(Array<T> array) {
        double sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum += array.get(i).doubleValue();
        }
        return sum / array.length();
    }

    //Test
    public static void main(String[] args) {
        Array<Integer> set1 = new Array<>(new Integer[]{1, 2, 4, 5});
        double averageValue1 = ArrayUtil.averageValue(set1);
        System.out.println(averageValue1);

        Array<Double> set2 = new Array<>(new Double[]{1.0, 3.0, 5.0});
        double averageValue2 = ArrayUtil.averageValue(set1);
        System.out.println(averageValue1);
    }

    static class Array<T> {
        private final T[] array;

        public Array(T[] array) {
            this.array = array;
        }

        public T get(int index) {
            return array[index];
        }

        public int length() {
            return array.length;
        }
    }
}
