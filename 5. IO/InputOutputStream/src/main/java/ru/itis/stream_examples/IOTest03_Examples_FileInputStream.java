package ru.itis.stream_examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest03_Examples_FileInputStream {
    public static void main(String[] args) {
        // File file = Utils.getTestFile();
        File file = new File("/test/test.txt");
        try (InputStream in = new FileInputStream(file)) {
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
        } catch (IOException ex) {
            ex.printStackTrace();//Don't do this in real program
        }
    }
}
