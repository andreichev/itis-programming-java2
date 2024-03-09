package ru.itis.prisoners_dilemma.api;

import java.util.List;

public interface Strategy {
    Decision play(int levelNumber, List<Decision> lastGames);

    default String getName() {
        Student student = getClass().getAnnotation(Student.class);
        return student.name();
    }

    default boolean isNpc() {
        Student student = getClass().getAnnotation(Student.class);
        return student.npc();
    }
}
