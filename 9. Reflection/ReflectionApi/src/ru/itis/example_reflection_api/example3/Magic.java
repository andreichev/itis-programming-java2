package ru.itis.example_reflection_api.example3;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

public class Magic {
    @CallerSensitive
    static void whoCallsMe() {
        Class<?> caller = Reflection.getCallerClass();
        System.out.println(caller.getName());
    }
}
