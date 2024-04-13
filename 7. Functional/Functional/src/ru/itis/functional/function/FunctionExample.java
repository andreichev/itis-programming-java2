package ru.itis.functional.function;

import java.util.ArrayList;
import java.util.List;

public class FunctionExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<Integer> list2 = list1.stream()
                .map(Integer::valueOf)
                .toList();
    }
}
