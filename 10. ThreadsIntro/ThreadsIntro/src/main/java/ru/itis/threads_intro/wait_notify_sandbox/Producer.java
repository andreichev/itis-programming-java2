package ru.itis.threads_intro.wait_notify_sandbox;

class Producer implements Runnable {
    Store store;

    Producer(Store store){
        this.store = store;
    }

    public void run(){
        while (true) {
            store.put();
        }
    }
}
