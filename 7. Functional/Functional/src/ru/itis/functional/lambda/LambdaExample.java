package ru.itis.functional.lambda;

public class LambdaExample {
    static int dfgsfgdsfsdg(int x) {
        System.out.println("HELLO, WORLD!");
        return x + 1;
    }

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

        // METHOD REFERENCE
        A object3 = LambdaExample::dfgsfgdsfsdg;

        System.out.println(object1.doSomething(2));
    }
}
