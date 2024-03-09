package ru.itis.threads_intro.intro;

public class ThreadsIntro {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("A");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("B");
            }
        });
        thread2.start();
    }
}
