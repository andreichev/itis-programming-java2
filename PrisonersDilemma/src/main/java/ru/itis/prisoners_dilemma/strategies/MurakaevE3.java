package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Муракаев Эрлан")
public class MurakaevE3 implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        boolean lieFlag = false;
        int lieCount = 0;
        int lieLimit = 3;
        for (Decision game : lastGames) {
            if (game == Decision.LIE) {
                lieFlag = true;
                lieCount += 1;
            }
        }
        if (lieFlag) {
            if (lieCount >= lieLimit) {
                return Decision.LIE;
            }
            if (lastGames.size() == 0) {
                return Decision.COOPERATE;
            }
            return lastGames.get(lastGames.size() - 1);
        } else {
            return Decision.COOPERATE;
        }
    }
}
