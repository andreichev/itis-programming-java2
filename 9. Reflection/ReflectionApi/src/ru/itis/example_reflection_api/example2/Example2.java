package ru.itis.example_reflection_api.example2;

import java.lang.reflect.Method;

public class Example2 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ru.itis.example_reflection_api.example2.A");

        Object object = clazz.getDeclaredConstructor().newInstance();
        Method func = clazz.getDeclaredMethod("func");
        func.setAccessible(true);
        func.invoke(object);
    }
}
