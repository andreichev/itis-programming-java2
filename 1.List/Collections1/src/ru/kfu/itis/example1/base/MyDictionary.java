package ru.kfu.itis.example1.base;

public interface MyDictionary extends Collection {
    void add(String key, String value);
    String get(String key);
}
