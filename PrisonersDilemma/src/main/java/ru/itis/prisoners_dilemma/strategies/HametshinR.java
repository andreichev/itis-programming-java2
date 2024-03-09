package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Хаметшин Ренат")
public class HametshinR implements Strategy {

    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int liesCount = 0;
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) liesCount++;
        }
        float liesPercent = (float) liesCount / lastGames.size();
        return liesPercent >= 0.1 ? Decision.LIE : Decision.COOPERATE;
    }
}
