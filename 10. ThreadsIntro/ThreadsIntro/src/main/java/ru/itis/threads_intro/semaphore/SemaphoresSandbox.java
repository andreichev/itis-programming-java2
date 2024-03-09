package ru.itis.threads_intro.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoresSandbox {
    private static final List<Integer> list = new ArrayList<>();
    static Integer counter = 0;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3);
                    semaphore.acquire();
                    list.add(++counter);
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1);
                    semaphore.acquire();
                    if (list.size() > 0) {
                        list.remove(0);
                    }
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread printThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3);
                    semaphore.acquire();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    semaphore.release();
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
