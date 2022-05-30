package ru.kfu.itis.example1.impl;

import ru.kfu.itis.example1.base.MyList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyListImpl<T> implements MyList<T> {
    private final Object[] elements = new Object[1000];
    private int size = 0;

    @Override
    public void add(T element) {
        elements[size] = element;
        size++;
    }

        @Override
    public void remove(int index) {
        if (first == null) {
            return;
        }
        if (first.value == get(index)) {
            first = first.next;
            --size;
            return;
        }
        Node current = first;
        while(current.next != null) {
            if (current.next.value == get(index)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void remove() {
        Node current = first;
        first = current.next;
        size--;
    }

    @Override
    public void remove(T t) {
        if (first == null) {
            return;
        }
        if (first.value == t) {
            first = first.next;
            --size;
            return;
        }
        Node current = first;
        while(current.next != null) {
            if (current.next.value == t) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {}

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
