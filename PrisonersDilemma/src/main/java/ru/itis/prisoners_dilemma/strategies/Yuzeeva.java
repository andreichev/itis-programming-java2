package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Гульшат")
public class Yuzeeva implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int k = 0;
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                k++;
            }
        }
        if (lastGames.size()!=0 && ((k/lastGames.size()*10)>5)){
            return Decision.LIE;
        }
        return Decision.COOPERATE;
    }
}
