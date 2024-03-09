package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Абдуллин Данияр")
public class AbdullinD implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE || levelNumber > 130) {
                return Decision.LIE;
            }
        }
        return (int)(Math.random() * 20) == 0 ? Decision.COOPERATE : Decision.LIE;
    }

}
