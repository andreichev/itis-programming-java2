package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Гасимов Наиль")
public class GasimovN implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
           double res = Math.random();
           if (res >= 0.8) {
               return Decision.COOPERATE;
           }

        return Decision.LIE;
    }
}

