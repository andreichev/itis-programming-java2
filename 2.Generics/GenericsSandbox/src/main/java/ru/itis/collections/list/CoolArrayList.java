package ru.itis.collections.list;

public class CoolArrayList<T> implements CoolList<T> {
    private Object[] array = new Object[2];
    private int count = 0;

    @Override
    public void add(T x) {
        array[count] = x;
        count++;
        if(count == array.length) {
            grow();
        }
    }

    @Override
    public void add(T x, int index) {
        // TODO: Implement
    }

    @Override
    public void set(T x, int index) {
        array[index] = x;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void remove(int index) {
        // TODO: Implement
    }

    @Override
    public void clear() {
        // TODO: Implement
    }

    @Override
    public int size() {
        return count;
    }

    private void grow() {
        System.out.println("ПЕРЕСОЗДАНИЕ МАССИВА");
        Object[] oldArray = array;
        array = new Object[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }
}
