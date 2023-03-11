package ru.itis.functional.lambda;

public class LambdaExample {
    public static void main(String[] args) {
        // FULL ANONYM CLASS DEFINITION
        A object1 = new A() {
            @Override
            public int doSomething(int x) {
                System.out.println("HELLO, WORLD!");
                return x + 1;
            }
        };

        // LAMBDA EXPRESSION
        A object2 = x -> {
            System.out.println("HELLO, WORLD!");
            return x + 1;
        };
    }
}
