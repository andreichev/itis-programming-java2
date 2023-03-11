package ru.itis.threads_intro.synchrinized_example;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedSandbox {
    private static List<Integer> list = new ArrayList<>();
    static Integer counter = 0;
    static final Object synchronizationKey = new Object();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3);
                    synchronized (synchronizationKey) {
                        list.add(++counter);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1);
                    synchronized (synchronizationKey) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread printThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3);
                    synchronized (synchronizationKey) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.print(list.get(i) + " ");
                        }
                        System.out.println();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        printThread.start();
    }
}
