package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Салахиев Тимур")
public class SalakhievT implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        if(levelNumber < 4) {
            return Decision.LIE;
        }
        if(lastGames.get(lastGames.size() - 1) == Decision.LIE || lastGames.get(lastGames.size() - 2) == Decision.LIE || lastGames.get(lastGames.size() - 3) == Decision.LIE || lastGames.get(lastGames.size() - 4) == Decision.LIE) {
            return Decision.LIE;
        }
        return Decision.COOPERATE;
    }
}

