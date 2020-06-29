package sprint06.task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class App {

    static Consumer<double[]> cons = (double[] d) -> {
        for (int i = 0; i < d.length; i++) {
            if (d[i] > 2.0) {
                d[i] *= 0.8;
            } else {
                d[i] *= 0.9;
            }
        }

    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> c) {
        double[] result = initialArray.clone();
        c.accept(result);
        return result;
    }

    //Test
    public static void main(String[] args) {
        double[] oldArr = {1.0,1.5,2.5,3.5};
        double[] newArr = new double[oldArr.length];
        newArr = getChanged(oldArr,cons);
        Arrays.stream(oldArr).forEach(System.out::println);
        Arrays.stream(newArr).forEach(System.out::println);

    }
}