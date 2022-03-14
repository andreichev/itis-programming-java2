package ru.itis.stream_examples;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class IOTest04_Examples_FileReader {

    public static void main(String[] args) {
        File file = Utils.getTestFile();
//    File file = new File("/tmp/text.txt");
        try (FileReader in = new FileReader(file)) {
            System.out.println((char) in.read());
            System.out.println((char) in.read());
            System.out.println((char) in.read());
            System.out.println((char) in.read());
        } catch (IOException ex) {
            ex.printStackTrace(); //Don't do this in real program
        }
    }
}
