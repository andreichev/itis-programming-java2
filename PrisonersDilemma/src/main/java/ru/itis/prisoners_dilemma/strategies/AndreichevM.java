package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Андреичев Михаил")
public class AndreichevM implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        return (int)(Math.random() * 2) == 0 ? Decision.COOPERATE : Decision.LIE;
    }
}
