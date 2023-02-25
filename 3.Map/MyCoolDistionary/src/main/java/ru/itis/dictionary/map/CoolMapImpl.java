package ru.itis.dictionary.map;

public class CoolMapImpl<K, V> implements CoolMap<K, V> {
    private final Object[] keys = new Object[100];
    private final Object[] values = new Object[100];
    private int size = 0;


    public void put(K key, V value) {
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public V get(K key) {
        for(int i = 0; i < size; i++) {
            if(keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
