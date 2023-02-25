package ru.itis.collections.iterating;

import ru.itis.collections.sorting.CoolListSorter;
import ru.itis.collections.sorting.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterExample {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        // IntList list = new ArrayListInt();
        list1.add(new Student("Ivan", 120));
        list1.add(new Student("Anton", 210));
        list1.add(new Student("Akakij", 130));
        list1.add(new Student("Ahmed", 184));
        list1.add(new Student("Anya", 150));
        list1.add(new Student("Rasim", 184));

        Iterator<Student> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }

        for (Student student : list1) {
            System.out.println(student);
        }
    }
}
