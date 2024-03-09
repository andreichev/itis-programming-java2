package ru.itis.prisoners_dilemma.strategies;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;
import ru.itis.prisoners_dilemma.api.Student;

import java.util.List;

@Student(name = "Леонтьев Дмитрий")
public class LeontevD implements Strategy{
    @Override
    public Decision play(int levelNumber, List<Decision> lastGames) {return Decision.LIE;}
}

