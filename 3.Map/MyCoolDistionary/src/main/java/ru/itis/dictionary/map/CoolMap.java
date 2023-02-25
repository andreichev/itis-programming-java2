package ru.itis.dictionary.map;

public interface CoolMap<K, V> {
    void put(K key, V value);
    V get(K key);
}
