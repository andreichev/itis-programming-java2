package ru.kfu.itis.example1.impl;

import ru.kfu.itis.example1.base.MyList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyListOptimized<T> implements MyList<T> {
    private int INCREMENT_VALUE = 4;
    private int arraySize  = 4;
    private Object[] elements = new Object[arraySize];
    private int size = 0;

    @Override
    public void add(T element) {
        if(size >= arraySize) {
            int beforeSize = arraySize;
            int afterSize = arraySize + INCREMENT_VALUE;
            arraySize = afterSize;
            System.out.println("Пересоздание массива! Новый размер: " + afterSize);

            Object[] beforeArray = new Object[beforeSize];
            for (int i = 0; i < beforeSize; i++) {
                beforeArray[i] = elements[i];
            }

            elements = new Object[afterSize];
            for (int i = 0; i < beforeSize; i++) {
                elements[i] = beforeArray[i];
            }
        }

        elements[size] = element;
        size++;
    }

    // TODO: Реализовать
    @Override
    public void remove(int index) {}

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    // Iterator

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
