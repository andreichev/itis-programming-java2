package ru.itis.collections;

import ru.itis.collections.list.CoolArrayList;
import ru.itis.collections.list.CoolList;

public class Main {
    public static void main(String[] args) {
        CoolList<Integer> list1 = new CoolArrayList<>();
        // IntList list = new ArrayListInt();
        list1.add(1);
        list1.add(5);
        list1.add(10);
        list1.add(12);
        list1.add(4);
        list1.add(3);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }

        CoolList<String> list2 = new CoolArrayList<>();
        // IntList list = new ArrayListInt();
        list2.add("One");
        list2.add("Two");
        list2.add("Five");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
    }
}
