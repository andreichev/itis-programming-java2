package ru.itis.functional.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zero");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        // Пример фильтрации массива
        List<String> result = list.stream()
                .filter(line -> line.length() > 3)
                .toList();

        for(String line: result) {
            System.out.println(line);
        }
    }
}
