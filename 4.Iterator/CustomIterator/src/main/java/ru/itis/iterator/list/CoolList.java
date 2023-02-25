package ru.itis.iterator.list;

public interface CoolList<T> extends Iterable<T> {
    void add(T x);
    void add(T x, int index);
    void set(T x, int index);
    T get(int index);
    void remove(int index);
    void clear();
    int size();
}
