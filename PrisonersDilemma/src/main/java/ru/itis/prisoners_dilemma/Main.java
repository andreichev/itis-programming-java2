package ru.itis.prisoners_dilemma;

import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;
import ru.itis.prisoners_dilemma.exceptions.GameException;
import ru.itis.prisoners_dilemma.reflect.ClassesScanner;
import ru.itis.prisoners_dilemma.service.GameExecutor;
import ru.itis.prisoners_dilemma.service.GameResult;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Class<?>> classes = ClassesScanner.getClasses("ru.itis.prisoners_dilemma.strategies");
        List<Strategy> games = new LinkedList<>();
        try {
            for (Class<?> clazz : classes) {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                if(instance instanceof Strategy strategy) {
                    if(!clazz.isAnnotationPresent(Student.class)) {
                        System.err.println("Нет аннотации у файла " + clazz.getSimpleName());
                        return;
                    }
                    System.out.println(strategy.getName() + " в игре!");
                    games.add(strategy);
                } else {
                    System.err.println("Неверный класс у файла " + clazz.getSimpleName());
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        battle(games, true);
    }

    @SuppressWarnings("SameParameterValue")
    private static void battle(List<Strategy> strategies, boolean log) {
        Map<String, Integer> scores = new HashMap<>();
        for(int i = 0; i < strategies.size(); i++) {
            for(int j = i + 1; j < strategies.size(); j++) {
                if(strategies.get(i).getName().equals(strategies.get(j).getName())) {
                    throw new GameException("Одинаковые имена: " + strategies.get(i).getName());
                }
            }
        }
        for (Strategy strategy : strategies) scores.put(strategy.getName(), 0);
        for (Strategy first : strategies) {
            for (Strategy second : strategies) {
                String firstName = first.getName();
                String secondName = second.getName();

                GameExecutor gameExecutor = new GameExecutor(first, second);
                GameResult result = gameExecutor.execute(log);
                int firstScore = scores.get(firstName) + result.first();
                int secondScore = scores.get(secondName) + result.second();
                scores.put(firstName, firstScore);
                scores.put(secondName, secondScore);
            }
        }
        System.out.println("-------------------");
        System.out.println("Результаты игры:");
        List<Map.Entry<String, Integer>> entries = scores.entrySet().stream()
                .sorted((l, r) -> -l.getValue().compareTo(r.getValue()))
                .toList();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println("Игрок " + entry.getKey() + ", очки: " + entry.getValue());
        }
    }
}