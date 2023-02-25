package ru.itis.collections.list;

public interface CoolList<T> {
    void add(T x);
    void add(T x, int index);
    void set(T x, int index);
    T get(int index);
    void remove(int index);
    void clear();
    int size();
}
