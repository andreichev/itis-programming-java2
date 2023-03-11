package ru.itis.stream_examples;

import java.io.IOException;
import java.io.InputStream;

public class IOTest01_Terminal {
    public static void main(String[] args) throws IOException {
        InputStream stream = System.in;
        int b;
        while((b = stream.read()) != -1) {
            System.out.print((char) b);
        }
    }
}
