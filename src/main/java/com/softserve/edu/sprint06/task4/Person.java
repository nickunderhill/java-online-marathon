package sprint06.task4;

import java.util.ArrayList;
import java.util.List;

class Person {

    String name;
    String product = "product1";
    int discount = 10;

    Person(String name) {
        this.name = name;
    }

    public DecisionMethod<String, Integer> goShopping = (p, d) -> {
        return product.equals(p) && d > discount;
    };
}

@FunctionalInterface
interface DecisionMethod<T, T1> {
    boolean decide(String s, int i);
}

class Shop {
    public List<DecisionMethod<String, Integer>> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        final int[] count = {0};
        clients.forEach(c -> {
            if (c.decide(product, percent)) {
                count[0]++;
            }
        });
        return count[0];
    }
}