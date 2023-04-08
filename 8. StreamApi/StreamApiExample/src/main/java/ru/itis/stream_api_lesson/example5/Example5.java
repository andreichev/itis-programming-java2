package ru.itis.stream_api_lesson.example5;

import ru.itis.stream_api_lesson.model.User;

import java.util.Arrays;
import java.util.List;

public class Example5 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Michael", "Robert", 37, "TR"),
                new User(2, "Mary", "Patricia", 11, "EN"),
                new User(3, "John", "Michael", 7, "FR"),
                new User(4, "Jennifer", "Linda", 77, "TR"),
                new User(5, "William", "Elizabeth", 23, "US"),
                new User(6, "Sue", "Jackson", 11, "IT"),
                new User(7, "Michael", "Tommy", 37, "EN")
        );

        long count = users.stream()
                .filter(item -> item.getAge() > 30)
                .count();
        System.out.println(count);
    }
}
