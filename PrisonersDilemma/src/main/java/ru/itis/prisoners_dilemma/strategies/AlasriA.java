package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;
import java.util.Random;

@Student(name = "Аль-Асри Ахмед")
public class AlasriA implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        Random rnd = new Random();
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                if (rnd.nextInt(1, 11) == 1 || rnd.nextInt(1, 11) == 2){
                    break;
                }
                return Decision.LIE;
            }
            if (rnd.nextInt(1, 11) == 1 || rnd.nextInt(1, 11) == 2){
                break;
            }
        }
        return (rnd.nextInt(1, 11) == 1 || rnd.nextInt(1, 11) == 2) ? Decision.COOPERATE : Decision.LIE;
    }
}
