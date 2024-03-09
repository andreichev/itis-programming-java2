package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Булат Хафизов")
public class BulatKhafizov implements Strategy {

    private final Decision[] mask = {
            Decision.LIE,
            Decision.LIE,
            Decision.COOPERATE,
            Decision.LIE,
            Decision.COOPERATE,
            Decision.COOPERATE,
    };

    private boolean checkMask(List<Decision> lastGames) {
        for (int i = 0; i < mask.length; i++) {
            if (lastGames.get(i) != mask[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        if (lastGames.size() < mask.length) {
            return mask[levelNumber];
        }

        if (checkMask(lastGames)) {
            return Decision.COOPERATE;
        }

        return Decision.LIE;
    }
}