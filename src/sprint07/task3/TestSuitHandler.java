package sprint07.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class TestSuitHandler {
    static void run(Class<?> clazz) {
        try {
            if (!clazz.isAnnotationPresent(TestSuite.class)) {
                System.out.println(
                        "Class " + clazz.getName() + " isn't annotated");
                return;
            }

            Object instance = clazz.getDeclaredConstructor().newInstance();

            String[] annotatedList = clazz.getDeclaredAnnotation(TestSuite.class).value();

        for (String s : annotatedList) {
            try {
                if (Modifier.isPublic(clazz.getDeclaredMethod(s).getModifiers())
                        && !Modifier.isStatic(clazz.getDeclaredMethod(s).getModifiers())) {
                    System.out.println("\t -- Method " + clazz.getSimpleName() + "." + s + " started --");
                    clazz.getDeclaredMethod(s).invoke(instance);
                    System.out.println("\t -- Method " + clazz.getSimpleName() + "." + s + " finished --");
                } else {
                    throw new NoSuchMethodException();
                }
            } catch (NoSuchMethodException e) {
                System.out.println(
                        "Method with name "
                                + s
                                + " doesn't exists or not public in class "
                                + clazz.getSimpleName());
            }
        }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface TestSuite {
    String[] value() default "";
}
