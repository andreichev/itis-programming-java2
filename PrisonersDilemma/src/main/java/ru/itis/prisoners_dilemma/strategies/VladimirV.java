package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Лисицын Владимир")
public class VladimirV implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.COOPERATE || levelNumber % 3 == 0 || levelNumber % 7 == 0)  {
                return Decision.LIE;
            }
        }
        return Decision.COOPERATE;
    }
}
