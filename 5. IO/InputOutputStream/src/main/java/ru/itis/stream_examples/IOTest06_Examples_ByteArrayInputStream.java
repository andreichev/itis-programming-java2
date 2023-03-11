package ru.itis.stream_examples;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class IOTest06_Examples_ByteArrayInputStream {
    public static void main(String[] args) {
        byte[] data = new byte[]{(byte) 0x1, (byte) 0x10, (byte) 0xFF};
        try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
        } catch (IOException ex) {
            ex.printStackTrace();//Don't do this in real program
        }
    }
}
