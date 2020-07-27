package sprint09.task6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {

        Map<String, Stream<String>> result = list.stream()
                .flatMap(s -> s)
                .filter(Objects::nonNull)
                .map(s -> s.replaceAll("[(),\\-, ]", ""))
                .distinct()
                .filter(s -> !s.equals(""))
                .map(MyUtils::formatNum)
                .collect(Collectors
                        .groupingBy(s -> s.substring(0, 3))
                )
                .entrySet()
                .stream()
                .collect(
                        Collectors
                                .toMap(m -> m.getKey(),
                                        m -> m.getValue()
                                                .stream()
                                                .map(s -> s.substring(4))
                                                .sorted()
                                )
                );
        return result;
    }

    private static String formatNum(String s) {
        if (s.startsWith("0")) {
            s = s.substring(0, 3) + " " + s.substring(3);
        } else if (s.length() == 7) {
            s = "loc " + s;
        } else {
            s = "err " + s;
        }
        return s;
    }


    public static void main(String[] args) {
        List<Stream<String>> testList = new ArrayList<Stream<String>>() {{
            add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
            add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
            add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45", null));
            add(Stream.of());
            add(Stream.of("", " "));
            add(Arrays.stream(new String[]{null}));
            add(null);
        }};

        MyUtils m = new MyUtils();

        for (Map.Entry<String, Stream<String>> entry : m.phoneNumbers(testList).entrySet()) {
            System.out.println(entry.getKey()
                    + ": " + entry.getValue().collect(Collectors.joining(",")));
        }

    }
}
