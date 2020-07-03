package sprint07.task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";

    static boolean checkAndPrint(Class clazz) {
        boolean result = true;

        //Filter
        List<Method> methodList = Arrays
                .stream(clazz.getMethods())
                .filter(method -> method.isAnnotationPresent(CamelCase.class)
                        && !Pattern.matches(CAMELCASE_PATTERN, method.getName()))
                .collect(Collectors.toList());
        //Print
        methodList.stream()
                .map(
                        method -> String.format(
                                "method %s.%s doesn't satisfy camelCase naming convention",
                                clazz.getSimpleName(),
                                method.getName()
                        )
                )
                .forEach(System.out::println);

        return result;
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase {
}


class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String[] args) {
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

