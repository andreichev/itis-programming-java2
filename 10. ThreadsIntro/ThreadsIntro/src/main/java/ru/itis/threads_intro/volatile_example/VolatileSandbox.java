package ru.itis.threads_intro.volatile_example;

public class VolatileSandbox {
    static int i = 0;
    static final Object o = new Object();

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            int count = 0;
            while (i < 1000000) {
                count++;
                i++;
            }
            System.out.println("THREAD 1: " + count);
        });
        Thread thread2 = new Thread(() -> {
            int count = 0;
            while (i < 1000000) {
                count++;
                i++;
            }
            System.out.println("THREAD 2: " + count);
        });
        Thread thread3 = new Thread(() -> {
            int count = 0;
            while (i < 1000000) {
                count++;
                i++;
            }
            System.out.println("THREAD 3: " + count);
        });
        Thread thread4 = new Thread(() -> {
            int count = 0;
            while (i < 1000000) {
                count++;
                i++;
            }
            System.out.println("THREAD 4: " + count);
        });

        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e6 + " ms");
        System.out.println(i);
    }
}
