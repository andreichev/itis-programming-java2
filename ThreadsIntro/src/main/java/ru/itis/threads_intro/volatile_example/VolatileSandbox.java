package ru.itis.threads_intro.volatile_example;

public class VolatileSandbox {
    static volatile int i = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (i < 1000000) {
                i++;
            }
        });
        Thread thread2 = new Thread(() -> {
            while (i < 1000000) {
                i++;
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }
}
