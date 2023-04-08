package ru.itis.stream_api_lesson.example2;

import java.util.Arrays;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream()
                .filter(item -> item % 2 == 0)
                .map(item -> {
                    int abs = Math.abs(item) % 10;
                    if(abs == 0) {
                        return item + " попугаев";
                    } else if (abs == 1) {
                        return item + " попугай";
                    } else if (abs < 5) {
                        return item + " попугая";
                    } else {
                        return item + " попугаев";
                    }
                })
                .forEach(System.out::println);
    }
}
