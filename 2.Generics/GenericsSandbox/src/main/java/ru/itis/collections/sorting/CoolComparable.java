package ru.itis.collections.sorting;

public interface CoolComparable<T> {
    // 0 - равны
    // -1 - o больше
    // 1 - this больше
    int compareTo(T o);
}
