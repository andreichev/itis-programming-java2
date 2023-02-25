package ru.itis.collections.sorting;

import ru.itis.collections.list.CoolArrayList;
import ru.itis.collections.list.CoolList;

public class SortingMain {
    public static void main(String[] args) {
        CoolList<Student> list1 = new CoolArrayList<>();
        // IntList list = new ArrayListInt();
        list1.add(new Student("Ivan", 120));
        list1.add(new Student("Anton", 210));
        list1.add(new Student("Akakij", 130));
        list1.add(new Student("Ahmed", 184));
        list1.add(new Student("Anya", 150));
        list1.add(new Student("Rasim", 184));

        CoolListSorter<Student> listSorter = new CoolListSorter<>();
        listSorter.sort(list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }


    }
}
