package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;
import java.util.Random;

@Student(name = "Пестриков Артем")
public class PestrikovA implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        Random random = new Random();
        int num = random.nextInt(100);
        if (num <= 20) {
            return Decision.COOPERATE;
        }
        return Decision.LIE;
    }
}

