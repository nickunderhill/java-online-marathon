package com.softserve.edu.sprint07.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface TestSuite {
    String[] value() default "";
}

public class TestSuitHandler {
    static void run(Class<?> clazz) {
        try {
            if (!clazz.isAnnotationPresent(TestSuite.class)) {
                System.out.println(
                        "Class " + clazz.getName() + " isn't annotated");
            } else {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                String[] annotatedList = clazz.getDeclaredAnnotation(TestSuite.class).value();

                for (String mName : annotatedList) {
                    try {
                        if (validateMods(clazz, mName)) {
                            System.out.println("\t -- Method "
                                    + clazz.getSimpleName() + "." + mName
                                    + " started --");
                            clazz.getDeclaredMethod(mName).invoke(instance);
                            System.out.println("\t -- Method "
                                    + clazz.getSimpleName() + "." + mName
                                    + " finished --");
                        } else {
                            throw new NoSuchMethodException();
                        }
                    } catch (NoSuchMethodException e) {
                        System.out.println(
                                "Method with name "
                                        + mName
                                        + " doesn't exists or not public in class "
                                        + clazz.getSimpleName());
                    }
                }
            }
        } catch (ReflectiveOperationException e) {
            System.out.println(e);
        }
    }

    private static boolean validateMods(Class<?> clazz, String mName) throws NoSuchMethodException {
        return Modifier.isPublic(clazz.getDeclaredMethod(mName).getModifiers())
                && !Modifier.isStatic(clazz.getDeclaredMethod(mName).getModifiers());
    }
}