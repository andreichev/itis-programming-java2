package ru.itis.stream_examples;

import java.io.*;

public class IOTest01_NewFile {
    public static void main(String[] args) {
        try {
            FileOutputStream file = new FileOutputStream("test" + File.separator +"test.txt");
            PrintStream printStream = new PrintStream(file);
            printStream.println("HELLO!");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
    }
}
