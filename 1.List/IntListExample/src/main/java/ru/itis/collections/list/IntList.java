package ru.itis.collections.list;

public interface IntList {
    void add(int x);
    void add(int x, int index);
    void set(int x, int index);
    int get(int index);
    void remove(int index);
    void clear();
    int size();
}
