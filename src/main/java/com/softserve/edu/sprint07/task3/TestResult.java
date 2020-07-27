package com.softserve.edu.sprint07.task3;

import java.lang.reflect.InvocationTargetException;

public class TestResult {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        TestSuitHandler.run(Class1.class);
        TestSuitHandler.run(Class2.class);
        TestSuitHandler.run(Class3.class);
        TestSuitHandler.run(Class4.class);
        TestSuitHandler.run(Suite1.class);
    }
}

@TestSuite({"m1", "m2"})
class Class1 {
    public void m2() {
        System.out.println("Hello from Class1");
    }
}

@TestSuite({"m1", "m2"})
class Class2 {
    public void m3() {
        System.out.println("Hello from Class2");
    }
}

class Class3 {
    public void m2() {
        System.out.println("Hello from Class3");
    }
}

@TestSuite()
class Class4 {
    public void m2() {
        System.out.println("Hello from Class3");
    }
}

@TestSuite({"method1", "method2", "method5"})
class Suite1 {

    String method1() {
        return "inside method1";
    }

    public void method2() {
        System.out.println("from void method 2");
    }

    public void method3() {
    }
}



/*

Class Suite2 isn't annotated
ClassSuite2 isn't annotated

        */
