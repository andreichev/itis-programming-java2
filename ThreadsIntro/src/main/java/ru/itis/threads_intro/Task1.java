package ru.itis.threads_intro;

import java.util.Scanner;

// Написать программу, которая будет выводить в консоль сообщение TEST MESSAGE,
// пока пользователь не нажмет Enter в консоли

public class Task1 {
    static boolean exit = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (exit == false) {
                System.out.println("TEST MESSAGE");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        new Scanner(System.in).nextLine();
        exit = true;
    }
}
