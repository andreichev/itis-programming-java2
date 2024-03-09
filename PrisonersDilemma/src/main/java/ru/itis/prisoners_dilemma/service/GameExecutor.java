package ru.itis.prisoners_dilemma.service;

import ru.itis.prisoners_dilemma.api.Decision;
import ru.itis.prisoners_dilemma.api.Strategy;

import java.util.ArrayList;
import java.util.List;

public class GameExecutor {
    private final Strategy firstStrategy;
    private final Strategy secondStrategy;
    private final int roundsNumber;
    private final List<Decision> firstDecisions;
    private final List<Decision> secondDecisions;
    private int firstScore;
    private int secondScore;

    public GameExecutor(Strategy firstStrategy, Strategy secondStrategy) {
        this.firstStrategy = firstStrategy;
        this.secondStrategy = secondStrategy;

        roundsNumber = 100 + (int)(Math.random() * 50);
        firstDecisions = new ArrayList<>();
        secondDecisions = new ArrayList<>();

        firstScore = 0;
        secondScore = 0;
    }

    public GameResult execute(boolean log) {
        if(log) {
            System.out.println();
            System.out.println("Игра между " + firstStrategy.getName() +
                    " и " + secondStrategy.getName() + ", " + roundsNumber + " раундов");
        }

        for (int round = 0; round < roundsNumber; round++) {
            Decision firstStrategyDecision = firstStrategy.play(round, secondDecisions);
            Decision secondStrategyDecision = secondStrategy.play(round, firstDecisions);

            firstDecisions.add(firstStrategyDecision);
            secondDecisions.add(secondStrategyDecision);

            if(Decision.COOPERATE.equals(firstStrategyDecision)) {
                if(Decision.COOPERATE.equals(secondStrategyDecision)) {
                    // Оба сотрудничают
                    firstScore += 3;
                    secondScore += 3;
                } else {
                    // Второй предаёт
                    secondScore += 5;
                }
            } else {
                if(Decision.COOPERATE.equals(secondStrategyDecision)) {
                    // Первый предаёт
                    firstScore += 5;
                } else {
                    // Оба предают
                    firstScore++;
                    secondScore++;
                }
            }
        }

        if(log) {
            System.out.println("Игра завершена:");
            for(Decision d : firstDecisions) {
                if(Decision.COOPERATE.equals(d)) {
                    System.out.print("#");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
            for(Decision d : secondDecisions) {
                if(Decision.COOPERATE.equals(d)) {
                    System.out.print("#");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
            System.out.println("Очки:");
            System.out.println(firstStrategy.getName() + ": " + firstScore + " points");
            System.out.println(secondStrategy.getName() + ": " + secondScore + " points");
        }
        return new GameResult(firstScore, secondScore);
    }
}
