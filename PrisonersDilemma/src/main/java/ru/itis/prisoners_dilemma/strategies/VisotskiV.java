package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Высоцкий Владимир", npc = true)
public class VisotskiV implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                return Decision.LIE;
            }
        }
        return Decision.COOPERATE;
    }
}
