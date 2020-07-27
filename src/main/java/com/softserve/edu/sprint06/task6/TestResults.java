package com.softserve.edu.sprint06.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestResults {

    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(8);
        }};

        Predicate<Integer> pr1 = x -> x != 5;
        Predicate<Integer> pr2 = x -> x != 7;
        Predicate<Integer> pr3 = x -> x < 5;

        System.out.println("findMaxByCondition: ");
        System.out.println(MyUtils.findMaxByCondition(listInt, pr1));

        User u = new User();
        u.values.add(1);
        u.values.add(3);
        u.values.add(5);
        u.values.add(7);

        System.out.println("getFilterdValue: ");
        int res = u.getFilterdValue(MyUtils::findMaxByCondition, pr2);
        System.out.println(res);

        System.out.println("getMaxValueByCondition: ");
        int res2 = u.getMaxValueByCondition(pr3);
        System.out.println(res2);
    }
}
