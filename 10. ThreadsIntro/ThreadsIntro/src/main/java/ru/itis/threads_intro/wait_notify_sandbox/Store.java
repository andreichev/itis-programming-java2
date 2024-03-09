package ru.itis.threads_intro.wait_notify_sandbox;

class Store {
    private int product = 0;

    public synchronized void get() {
        try {
            Thread.sleep(getRandomDelay());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
    }

    public synchronized void put() {
        try {
            Thread.sleep(getRandomDelay());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
    }

    private static long getRandomDelay() {
        return (long) (Math.random() * 150);
    }
}
