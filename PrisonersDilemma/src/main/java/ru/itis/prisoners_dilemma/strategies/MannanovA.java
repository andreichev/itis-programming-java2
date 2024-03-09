package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Маннанов Алмаз")
public class MannanovA implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int a = 0;
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                a++;
            }
            if (a == 3) {
                return Decision.COOPERATE;
            }
        }
        return Decision.LIE;
    }
}
