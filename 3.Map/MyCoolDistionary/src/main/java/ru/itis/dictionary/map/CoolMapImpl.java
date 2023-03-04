package ru.itis.dictionary.map;

import java.util.LinkedList;
import java.util.List;

public class CoolMapImpl<K, V> implements CoolMap<K, V> {
    final int COUNT = 10;

    static class MyEntry<K, V> {
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

    List<MyEntry<K, V>>[] lists = new LinkedList[COUNT];

    public CoolMapImpl() {
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    // O(1)
    public void put(K key, V value) {
        int keyHash = key.hashCode();
        List<MyEntry<K, V>> currentList = lists[getIndex(keyHash)];
        for(MyEntry<K, V> item: currentList) {
            if(item.key.equals(key)) {
                item.setValue(value);
                return;
            }
        }
        currentList.add(new MyEntry<>(key, value));
    }

    // O(1)
    public V get(K key) {
        int keyHash = key.hashCode();
        List<MyEntry<K, V>> currentList = lists[getIndex(keyHash)];
        for(MyEntry<K, V> item: currentList) {
            if(item.key.equals(key)) {
                return item.value;
            }
        }
        return null;
    }

    private int getIndex(int hash) {
        return Math.abs(hash) % COUNT;
    }
}
