package ru.itis.stream_examples;

import java.nio.charset.Charset;
import java.util.Map;

public class Sandbox {
    public static void main(String[] args) {
        Map<String, Charset> charsets = Charset.availableCharsets();
        for(String name: charsets.keySet()) {
            System.out.println(name);
        }
    }
}
