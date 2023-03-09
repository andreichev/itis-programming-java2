package ru.itis.dictionary;

import ru.itis.dictionary.map.CoolTreeMapImpl;

public class Main {
    public static void main(String[] args) {
         CoolTreeMapImpl<Integer, String> capitals = new CoolTreeMapImpl<>();
         capitals.put(2, "Tokyo");
         capitals.put(6, "ASDasdas");
         capitals.put(1, "Moscow");
         capitals.put(4, "London");
         capitals.put(0, "ASDasdas");
         capitals.put(5, "ASDasdas");
         capitals.put(8, "ASDasdas");

         System.out.println(capitals.get(4));

         capitals.print();
    }
}
