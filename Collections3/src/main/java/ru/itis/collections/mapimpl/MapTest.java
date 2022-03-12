package ru.itis.collections.mapimpl;

import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> capitals = new MyHashMap<String, String>();
        capitals.put("Japan", "Tokyo");
        capitals.put("Russia", "Moscow");
        capitals.put("Great Britain", "London");

        System.out.println(capitals.get("Russia"));
    }
}
