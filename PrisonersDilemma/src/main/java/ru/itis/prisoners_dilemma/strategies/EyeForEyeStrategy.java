package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Глаз за глаз", npc = true)
public class EyeForEyeStrategy implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        if(levelNumber == 0) {
            return Decision.COOPERATE;
        }
        if(Math.random() >= 0.8) {
            return Decision.COOPERATE;
        }
        return lastGames.get(levelNumber - 1);
    }
}
