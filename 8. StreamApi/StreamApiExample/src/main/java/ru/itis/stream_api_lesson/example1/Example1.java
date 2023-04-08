package ru.itis.stream_api_lesson.example1;

import java.util.Arrays;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // List<Integer> result = new ArrayList<>();
        // for (int i = 0; i < list.size(); i++) {
        //     if(list.get(i) % 2 == 0) {
        //         result.add(list.get(i));
        //     }
        // }
        // for (int i = 0; i < result.size(); i++) {
        //     System.out.print(result.get(i) + " | ");
        // }
        list.stream()
                .filter(item -> item % 2 == 0)
                .forEach(System.out::println);
    }
}
