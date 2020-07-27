package sprint06.task5;

import java.util.HashSet;
import java.util.function.Predicate;
import java.util.Set;

class MyUtils {

    // Write your code here
    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> result = x -> true;
        for (Predicate<Integer> p : predicates) {
            result = result.and(p);
        }
        return result;
    }

    //Test
    public static void main(String[] args) {

        Set<Predicate<Integer>> predicateSet = new HashSet<>();
        predicateSet.add(x -> x > 3);
        predicateSet.add(x -> x % 2 == 0);

        Predicate<Integer> predicate = getPredicateFromSet(predicateSet);

        System.out.println(predicate.test(6));
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(3));
    }
}
