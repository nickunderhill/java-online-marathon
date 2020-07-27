package com.softserve.edu.sprint07.task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.regex.Pattern;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase {
}

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";

    static boolean checkAndPrint(Class clazz) {
        final int[] countErr = {0};
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(CamelCase.class)
                        && !Pattern.matches(CAMELCASE_PATTERN, method.getName()))
                .map(
                        method -> String.format(
                                "method %s.%s doesn't satisfy camelCase naming convention",
                                clazz.getSimpleName(),
                                method.getName()
                        )
                )
                .forEach(
                        msg -> {
                            System.out.println(msg);
                            countErr[0]++;
                        });
        return countErr[0] == 0;
    }
}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    public static void _main(String[] args) {
    }

    @CamelCase
    public void Example() {
    }
}

class Class1 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void InCorrect() {
    }

    @CamelCase
    public void JustMethod() {
    }
}

class Class2 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void oneMoreCorrect() {
    }
}

