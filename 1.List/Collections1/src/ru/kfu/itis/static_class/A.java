package ru.kfu.itis.static_class;

public class A {
    static class B {
        int var1;

        public B(int var1) {
            this.var1 = var1;
        }

        void test() {
            System.out.println(var1);
        }
    }

    int var1;
    int var2;
    B object;

    public A(int var1, int var2, int var3) {
        this.var1 = var1;
        this.var2 = var2;
        object = new B(var3);
    }
}
