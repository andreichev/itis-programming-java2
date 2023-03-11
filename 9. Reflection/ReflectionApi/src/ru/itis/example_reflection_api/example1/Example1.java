package ru.itis.example_reflection_api.example1;

import java.lang.reflect.Field;

public class Example1 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Field nameField = person.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "Ivan");

        System.out.println(person.getName());
    }
}
