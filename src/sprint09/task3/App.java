package sprint09.task3;

import java.io.*;

public class App {
    public static void writeFile(String filename, String text) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            output.write(StringToBits(text).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String StringToBits(String str) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            String bitStr = Integer.toBinaryString(b);
            if (bitStr.length() < 7) {
                bitStr = String.format("%7s", Integer.toBinaryString(b))
                        .replaceAll(" ", "0");
            }
            result.append(bitStr);
        }
        return String.valueOf(result);
    }

    //Test
    public static void main(String[] args) {
        String file = "resources/1.txt";
        writeFile(file, "Hello!");
        writeFile(file, "Hello World!");
    }
}
