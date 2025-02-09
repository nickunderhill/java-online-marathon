package com.softserve.edu.sprint09.task3;

import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void writeFile(String filename, String text) {
        try {
            FileOutputStream output = new FileOutputStream(filename);
            output.write(StringToBinary(text).getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String StringToBinary(String str) {
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
        String file = "resources/2.txt";
        writeFile(file, "Hello!");
        writeFile(file, "Hello World!");
    }
}
