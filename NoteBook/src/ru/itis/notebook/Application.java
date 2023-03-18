package ru.itis.notebook;


public abstract class Application {
    protected String[] args;

    public Application(String[] args) {
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init();

    public abstract void start();
}