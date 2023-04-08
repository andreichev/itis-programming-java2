package ru.itis.stream_api.example;

import ru.itis.stream_api.model.Student;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("Ivan", "Ivanov", 50),
                new Student("Vasya", "Sidorov", 60),
                new Student("Anton", "Antonov", 70),
                new Student("Andrey", "Kuznecov", 80),
                new Student("Oleg", "Kulikov", 10),
                new Student("Ashot", "Ahmetov", 20)
        );
        list.stream()
            .map(item -> "Студент " + item.getLastName() + ", " + item.getScoreDescription())
            .forEach(System.out::println);
    }
}
