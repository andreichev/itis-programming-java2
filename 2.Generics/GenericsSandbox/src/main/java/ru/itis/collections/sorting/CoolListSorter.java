package ru.itis.collections.sorting;

import ru.itis.collections.list.CoolList;

public class CoolListSorter<T extends CoolComparable<T>> {
    void sort(CoolList<T> coolList) {
        for (int i = 0; i < coolList.size(); i++) {
            for (int j = i + 1; j < coolList.size(); j++) {
                T l = coolList.get(i);
                T r = coolList.get(j);
                if(l.compareTo(r) > 0) {
                    coolList.set(l, j);
                    coolList.set(r, i);
                }
            }
        }
    }
}
