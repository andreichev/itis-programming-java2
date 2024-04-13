package ru.itis.functional.consumer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zero");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

         // Consumer<String> printingConsumer = new Consumer<String>() {
         //     @Override
         //     public void accept(String s) {
         //         System.out.println(s);
         //     }
         // };
         // list.forEach(printingConsumer);

        // list.forEach(line -> System.out.println(line));

        list.forEach(System.out::println);
    }
}
