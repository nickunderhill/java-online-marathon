package sprint09.task5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        Stream<String> stringStream = map
                .values()
                .stream()
                .flatMap(Function.identity());
        return stringStream
                .filter(Objects::nonNull)
                .map(s -> s.replace(" ", ""))
                .filter(s -> !s.equals(""))
                .map(
                        name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase()
                )
                .distinct()
                .sorted();
    }

    //Tests
    public static void main(String[] args) {
        //Test1
        Map<String, Stream<String>> test = new HashMap<>();
        test.put("Desktop", Stream.of(" ivan", "Petro ", " Ira ", "", null));
        test.put("Web", Stream.of("Stepan", "ira ", " Andriy ", "anna"));
        test.put("Spring", Stream.of("Ivan", "Anna"));

        String[] res = new MyUtils().nameList(test).toArray(String[]::new);
        String[] expected = {"Andriy", "Anna", "Ira", "Ivan", "Petro", "Stepan"};
        boolean isOk = Arrays.equals(res, expected);
        System.out.println(isOk ? "OK" : "FAIL");
        if (!isOk) {
            System.out.println("Expected:");
            System.out.println(Arrays.toString(expected));
            System.out.println("But received:");
            System.out.println(Arrays.toString(res));
        }

        //Tests2
        Map<String, Stream<String>> test1 = new HashMap<>();
        test1.put("Desktop", Stream.of("", " ", "  ", ""));


        String[] res1 = new MyUtils().nameList(test1).toArray(String[]::new);
        String[] expected1 = {""};
        boolean isOk1 = Arrays.equals(res1, expected1);
        System.out.println(isOk1 ? "OK" : "FAIL");
        if (!isOk1) {
            System.out.println("Expected:");
            System.out.println(Arrays.toString(expected1));
            System.out.println("But received:");
            System.out.println(Arrays.toString(res1));
        }
    }
}
