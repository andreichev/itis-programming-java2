package ru.itis.example_reflection_api.example5;

import java.lang.reflect.Method;

public class Example5 {
    public static void main(String[] args) throws Exception {
        Class bClass = Class.forName("ru.itis.example_reflection_api.example5.B");
        Method func = bClass.getDeclaredMethod("func");
        System.out.println(func.getAnnotations().length);
    }
}
