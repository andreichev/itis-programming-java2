package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Дробышева Майя")
public class Maya implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int lzh = 0;
        Decision pd = null;
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                lzh++;
            }
            pd = lastGame;
        }
        if (!lastGames.isEmpty()) {
            if (lzh > lastGames.size() / 2.5 || pd.equals(Decision.LIE)) {
                return Decision.LIE;
            }
        }
        return Decision.COOPERATE;
    }
}
