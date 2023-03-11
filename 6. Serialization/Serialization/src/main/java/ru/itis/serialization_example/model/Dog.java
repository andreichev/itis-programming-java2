package ru.itis.serialization_example.model;

public class Dog implements Animal {
    String name;
    int age;
    String poroda;

    public Dog(String name, int age, String poroda) {
        this.name = name;
        this.age = age;
        this.poroda = poroda;
    }

    @Override
    public String toString() {
        return "Dog " + name;
    }
}
