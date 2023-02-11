package ru.itis.collections.list;

public class ArrayListInt implements IntList {
    private int[] array = new int[2];
    private int count = 0;

    @Override
    public void add(int x) {
        array[count] = x;
        count++;
        if(count == array.length) {
            grow();
        }
    }

    @Override
    public void add(int x, int index) {
        // TODO: Implement
    }

    @Override
    public void set(int x, int index) {
        array[index] = x;
    }

    @Override
    public int get(int index) {
        return array[index];
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
        int[] oldArray = array;
        array = new int[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }
}
