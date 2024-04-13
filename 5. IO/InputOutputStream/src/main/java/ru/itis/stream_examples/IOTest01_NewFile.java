package ru.itis.stream_examples;

import java.io.*;

public class IOTest01_NewFile {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream file = new FileOutputStream("test" + File.separator +"test.txt");
            // file.write(104);
            // file.write(101);
            // file.write(108);
            // file.write(108);
            // file.write(111);
            PrintStream printStream = new PrintStream(file);
            printStream.println("HELLO!");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
    }
}
