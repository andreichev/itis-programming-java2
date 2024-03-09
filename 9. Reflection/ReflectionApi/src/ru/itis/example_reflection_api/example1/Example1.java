package ru.itis.example_reflection_api.example1;

import java.lang.reflect.Field;

// Object
// Class
// Field

public class Example1 {
    public static void main(String[] args) throws Exception {
        Class<?> personClass = Person.class;
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);

        Person person1 = new Person();
        nameField.set(person1, "Ivan");
        System.out.println(person1.getName());

        Person person2 = new Person();
        System.out.println(person2.getName());
    }
}
