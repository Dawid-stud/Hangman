package com.company;

public class GameState {
    private String guessWord;
    private int healthPoint = 5;
    private char[] usedLetters;
    private int usedLettersIndex = 0;

    public GameState(String guessWord) {
        this.guessWord = guessWord;
        this.usedLetters = new char[guessWord.length()];
    }

    public boolean isCharInGuessWord(char userGuess) {
        return guessWord.contains(Character.toString(userGuess));
    }

    public boolean isCharAlreadyUsed(char userGuess) {
        for (char x : usedLetters) {
            if (x == userGuess) {
                return true;
            }
        }

        return false;
    }

    public void addUserGuess(char guess) {
        usedLetters[usedLettersIndex] = guess;
        usedLettersIndex++;
    }

    public String getGuessWord() {
        return guessWord;
    }

    public int loseHealthPointAndPrintLifePoints() {
        healthPoint--;
        System.out.println("Your health points: " + getHealthPoint());
        return healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
}
