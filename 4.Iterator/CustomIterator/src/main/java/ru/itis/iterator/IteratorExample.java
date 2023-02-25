package ru.itis.iterator;

import ru.itis.iterator.list.CoolArrayList;
import ru.itis.iterator.list.CoolList;

public class IteratorExample {
    public static void main(String[] args) {
        CoolList<String> list = new CoolArrayList<>();

        list.add("One");
        list.add("Four");
        list.add("Three");
        list.add("Two");

        for(String item: list) {
            System.out.println(item);
        }
    }
}
