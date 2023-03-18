package ru.itis.examples.anonymous;

public class PostImpl implements Post {
    @Override
    public String getMessage(String name) {
        return name + ", HELLO!";
    }
}
