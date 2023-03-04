package ru.itis.dictionary;

import ru.itis.dictionary.map.CoolMap;
import ru.itis.dictionary.map.CoolMapImpl;

public class Main {
    public static void main(String[] args) {
        CoolMap<String, String> capitals = new CoolMapImpl<>();
        capitals.put("Japan", "Tokyo");
        capitals.put("Russia", "Moscow");
        capitals.put("Great Britain", "London");

        System.out.println(capitals.get("Russia"));
    }
}
