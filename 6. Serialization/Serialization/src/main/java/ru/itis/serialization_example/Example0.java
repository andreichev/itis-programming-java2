package ru.itis.serialization_example;

import java.io.*;

public class Example0 {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("text.txt");
        DataInputStream inputStream = new DataInputStream(file);
        System.out.println(inputStream.readInt());
        // FileOutputStream file = new FileOutputStream("text.txt");
        // DataOutputStream outputStream = new DataOutputStream(file);
        // outputStream.writeInt(345721432);
        // outputStream.close();
    }
}
