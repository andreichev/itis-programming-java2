package ru.itis.threads_intro.wait_notify_sandbox;

class Consumer implements Runnable{
    Store store;

    Consumer(Store store){
        this.store = store;
    }

    public void run(){
        while (true) {
            store.get();
        }
    }
}
