package sprint06.task4;

import java.util.ArrayList;
import java.util.List;

class Person{
    String name;

    Person(String name){
        this.name = name;
    }

    Person(String name, String product, int discount) {
        this.name = name;
    }

    DecisionMethod<String, Integer> goShopping = (product, discount) -> {
        return product.equals("product1") && discount == 10;
    };
}

@FunctionalInterface
interface DecisionMethod<T, T1> {
    boolean decide(String s, int i);
}

class Shop{
    public List<DecisionMethod<String,Integer>> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count = 0;
        for (DecisionMethod<String,Integer> d: clients) {
            if (d.decide(product,percent)){
                count++;
            };
        }
        return count;

    }
}