package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;
import java.util.List;

import static java.lang.Math.abs;
import static ru.itis.prisoners_dilemma.api.Decision.LIE;

@Student(name = "Шарапова Дарья")
public class Sharapova implements Strategy {
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {
        int lie=0;
        int tru=0;
        if (lastGames.size()>0 && lastGames.get(lastGames.size()-1)==LIE){
            lie++;
        }
        else{
            tru++;
        }
        if (tru<5 || lie<5){
            return Decision.LIE;
        }

        if (lie-tru<5){
            return (int)(Math.random() * 2) == 0 ? Decision.COOPERATE : Decision.LIE;
        }

        return lastGames.get(lastGames.size()-1);
    }
}