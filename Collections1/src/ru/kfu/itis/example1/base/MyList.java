package ru.kfu.itis.example1.base;

public interface MyList<T> extends Collection, Iterable<T> {
    void add(T element);
    void remove(int index);
    void remove(T object);
    void remove();
    T get(int index);
}
