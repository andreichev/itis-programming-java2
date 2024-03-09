package ru.itis.prisoners_dilemma.strategies;


import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Гиндуллина Динара")
public class SamayaLuchshayaStrategiya implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        for (Decision lastGame : lastGames) {
            if (lastGame == Decision.LIE) {
                return Decision.LIE;
            }
            if (lastGame == Decision.COOPERATE){
                return Decision.COOPERATE;
            }
        }
        return Decision.COOPERATE;
    }



}
