package ru.itis.example_reflection_api.example4;

public class Example4 {
    static void func3() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for(StackTraceElement s: stackTrace) {
            System.out.println(s.getMethodName());
        }
    }

    static void func2() {
        func3();
    }

    static void func1() {
        func2();
    }

    public static void main(String[] args) {
        func1();
    }
}
