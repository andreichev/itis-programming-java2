package itis.homework.impl.linkedlist;

public interface LinkedList<T> {
    T get(int index);
    
    void add(T value);
    
    void insert(int index, T value);
    
    void remove(int index);
    
    int size();
}