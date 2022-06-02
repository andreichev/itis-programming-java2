package HomeWork.Threads;

import java.util.Scanner;

public class ThreadTest {
    static volatile int i = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("TEST MESSAGE");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            Scanner in = new Scanner(System.in);
            while (true) {
                if (in.nextLine().length() == 0)
                {
                    thread1.interrupt();
                    return;
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
