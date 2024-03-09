package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.beans.DesignMode;
import java.util.List;
@Student(name = "Хван Тимур")
public class KhvanT implements Strategy{
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.COOPERATE) {
                return Decision.LIE;
            }
        }
        return Decision.COOPERATE;
    }
}
