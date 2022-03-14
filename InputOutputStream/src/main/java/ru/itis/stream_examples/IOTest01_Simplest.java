package ru.itis.stream_examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest01_Simplest {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("test/test.txt");
            int b;
            while ((b = fileInputStream.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
