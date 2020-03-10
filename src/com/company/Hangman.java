package com.company;

import java.util.Scanner;

public class Hangman {
    private GameState gameState = new GameState("słowo");
    private Scanner scan = new Scanner(System.in);
    private Judge judge = new Judge(gameState);

    private void printHiddenGuessWord() {
        for (char x: gameState.getGuessWord().toCharArray()) {
            if (gameState.isCharAlreadyUsed(x)) {
                System.out.print(x);
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    private char getUserGuess() {
        while (true) {
            try {
                return scan.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowy znak");
            }
        }
    }

    public void start() {
        do {
            printHiddenGuessWord();
            char userGuess = getUserGuess();

            if (!gameState.isCharInGuessWord(userGuess)) {
                gameState.loseHealthPointAndPrintLifePoints();
                if (judge.isPlayerLose()) {
                    System.out.println("Przegrałeś!\n");
                    break;
                }
            }

            if (gameState.isCharAlreadyUsed(userGuess)
                    || !gameState.isCharInGuessWord(userGuess)) {
                continue;
            }
            gameState.addUserGuess(userGuess);

            if (judge.isPlayerWin()) {
                System.out.println("Wygrałeś!\n");
            }

        } while (judge.isGameEnd());
    }
}
