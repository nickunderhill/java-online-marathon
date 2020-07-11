package sprint09.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class App {

    public static String readFile(String filename) {
        StringBuilder fileContent = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        try {
            FileInputStream input = new FileInputStream(filename);
            int i;
            while ((i = input.read()) != -1) {
                fileContent.append((char) (i));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(fileContent.toString().split("(?<=\\G.{7})"))
                .forEach(str -> sbResult.append((char) Integer.parseInt(str, 2)));
        return sbResult.toString();
    }

    //Test
    public static void main(String[] args) {
        String testStr = readFile("resources/1.txt");
        System.out.println(testStr);
    }
}
