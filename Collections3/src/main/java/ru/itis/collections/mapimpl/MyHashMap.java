package ru.itis.collections.mapimpl;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {
    final int COUNT = 10;
    int size = 0;
    static class MyEntry<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    LinkedList<MyEntry<K, V>>[] entries = new LinkedList[COUNT];

    public MyHashMap() {
        for (int i = 0; i < COUNT; i++) {
            entries[i] = new LinkedList<MyEntry<K, V>>();
        }
    }

    public V put(K key, V value) {
        int keyHash = key.hashCode();
        int index = getEntriesListIndex(keyHash);
        entries[index].add(new MyEntry<K, V>(key, value));
        size++;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        throw new NotImplementedException();
    }

    public boolean containsValue(Object value) {
        throw new NotImplementedException();
    }

    public V get(Object key) {
        int keyHash = key.hashCode();
        List<MyEntry<K, V>> currentList = entries[getEntriesListIndex(keyHash)];
        for(MyEntry<K, V> item: currentList) {
            if(item.key.equals(key)) {
                return item.value;
            }
        }
        return null;
    }

    public V remove(Object key) {
        throw new NotImplementedException();
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        throw new NotImplementedException();
    }

    public void clear() {
        size = 0;
        entries = new LinkedList[COUNT];
        for (int i = 0; i < COUNT; i++) {
            entries[i] = new LinkedList<MyEntry<K, V>>();
        }
    }

    public Set<K> keySet() {
        throw new NotImplementedException();
    }

    public Collection<V> values() {
        throw new NotImplementedException();
    }

    public Set<Entry<K, V>> entrySet() {
        throw new NotImplementedException();
    }

    private int getEntriesListIndex(int hash) {
        return (0xffffff & hash) % COUNT;
    }
}
