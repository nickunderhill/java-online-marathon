package sprint07.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

public class Util {
    public static void review(String className) {
        try {
            messageGenerator(Class.forName(className));
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }

    private static void messageGenerator(Class<?> c) throws ClassNotFoundException {
        String msg;
        if (c.isAnnotationPresent(Review.class)) {
            msg = String.format(
                    "Class %s was reviewed %s by %s.",
                    c.getName(),
                    getDate(c.getName()),
                    c.getAnnotation(Review.class).reviewer());
        } else {
            msg = String.format(
                    "Class %s isn't marked as Reviewed",
                    c.getName());
        }
        System.out.println(msg);
    }

    private static String getDate(String className) throws ClassNotFoundException {
        String date = Class.forName(className).getAnnotation(Review.class).date();
        return date.equals("today") ? String.valueOf(LocalDate.now()) : date;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface Review {
    String reviewer();

    String date() default "today";
}
