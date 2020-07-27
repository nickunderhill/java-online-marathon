package sprint06.task1;

import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {
        return (int) Arrays.stream(array).filter(predicate::test).count();
    }

    //Test
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(getCount(arr1, (x)-> x%2 == 0));
        System.out.println(getCount(arr1, (x)-> x%2 == 1));
        System.out.println(getCount(arr1, (x)-> x > 8));
    }
}