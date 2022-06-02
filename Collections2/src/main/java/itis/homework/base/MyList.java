package itis.homework.base;

public interface MyList<T> extends Collection {
    void add(T element);
    void remove(int index);
    T get(int index);
}
