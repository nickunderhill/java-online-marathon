package sprint04.task3;

import java.util.*;

public class MyUtils {
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        boolean result = false;
        ArrayList<String> mapValuesList = new ArrayList<>(map.values());
        if(list.containsAll(mapValuesList) && mapValuesList.containsAll(list)){
            result = true;
        }
        return result;
    }

    //Test
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("aa", "bb", "aa", "cc");
        List<String> stringList2 = Collections.emptyList();
        Map<String,String> map = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        Map<String,String> map3 = new HashMap<>();
        map.put("1","cc");
        map.put("2","bb");
        map.put("3","cc");
        map.put("4","aa");
        map.put("5","cc");
        map3.put("1","ab");
        map3.put("2","bc");
        map3.put("3","cb");
        map3.put("4","ac");
        map3.put("5","ca");


        MyUtils m = new MyUtils();
        System.out.println("Has intersection test");
        System.out.println(m.listMapCompare(stringList,map));
        System.out.println("No intersection test");
        System.out.println(m.listMapCompare(stringList,map3));
        System.out.println("Empty list test");
        System.out.println(m.listMapCompare(stringList2,map));
        System.out.println("Empty map test");
        System.out.println(m.listMapCompare(stringList,map2));
        System.out.println("Empty list and map test");
        System.out.println(m.listMapCompare(stringList2,map2));
    }
}