package ru.itis.serialization_example.model;

public class Cat implements Animal {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat " + name;
    }
}
