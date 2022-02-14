package ru.kfu.itis.example1;

import ru.kfu.itis.example1.base.MyDictionary;
import ru.kfu.itis.example1.base.MyList;
import ru.kfu.itis.example1.impl.MyDictionaryImpl;
import ru.kfu.itis.example1.impl.MyListOptimized;

public class Example3 {
    public static void main(String[] args) {
        MyList<String> list1 = new MyListOptimized<>();

        list1.add("One");
        list1.add("Two");
        list1.add("Three");
        list1.add("Four");
        list1.add("Five"); // Тут должно быть пересоздание массива
        list1.add("Six");
        list1.add("Seven");
        list1.add("Eight");
        list1.add("Nine"); // Тут должно быть пересоздание массива
        list1.add("Ten");
        list1.add("Eleven");
        list1.add("Twelve");
        list1.add("Thirteen"); // Тут должно быть пересоздание массива
        list1.add("Fourteen");
        list1.add("Fifteen");

        list1.remove(2);

        for(int i = 0; i < list1.size(); i++) {
            System.out.println("Index: " + i + ", element: " + list1.get(i));
        }

        MyList<Integer> list2 = new MyListOptimized<>();
        list2.add(3);
        list2.add(5);
        list2.add(10);
        list2.add(14);
        list2.add(15);

        MyDictionary dictionary = new MyDictionaryImpl();
        dictionary.add("One", "Один");
        dictionary.add("Two", "Два");
        dictionary.add("Three", "Три");

        System.out.println(dictionary.get("Three"));
    }
}
