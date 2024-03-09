package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Хасаншин Мурат")
public class KhasanshinM implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int countLie = 0;
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                countLie++;
            } else {
                countLie--;
            }
        }
        if (countLie >= 2) {
            return Decision.LIE;
        }
        return Decision.COOPERATE;
    }
}