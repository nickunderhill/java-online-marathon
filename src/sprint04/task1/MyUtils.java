package sprint04.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> result = new HashMap<>();
        for (String num : phones.keySet()) {
            if (!result.containsKey(phones.get(num))) {
                result.put(phones.get(num), new ArrayList<>());
            }
            result.get(phones.get(num)).add(num);
        }
        return result;

    }

    //TEST
    public static void main(String[] args) {
        Map<String, String> phonesList = new HashMap<>();
        phonesList.put("0967654321", "Petro");
        phonesList.put("0677654321", "Petro");
        phonesList.put("0501234567", "Ivan");
        phonesList.put("0970011223", "Stepan");
        phonesList.put("0631234567", "Ivan");

        MyUtils m = new MyUtils();
        Map<String, List<String>> NewPhonesList = m.createNotebook(phonesList);

        //Initial Map
        System.out.println("Initial Map is : " + phonesList);

        // Resulting Map
        System.out.println("Resulting Map is : " + NewPhonesList);
    }
}
