package com.company;

public class Main {
    final static String NEW_GAME = "Rozpocznij grę";
    final static String ADD_WORD = "Dodaj słowo do słownika";
    final static String EXIT = "Wyjdź";

    public static void main(String[] args) {
        Menu menu = new Menu(
                NEW_GAME,
                ADD_WORD,
                EXIT
        );

        System.out.println("Witaj w grze!\n");

        while (true) {
            switch (menu.printMenuAndGetChoice()) {
                case NEW_GAME:
                    Hangman game = new Hangman();
                    game.start();

                    break;

                case EXIT:
                    System.exit(0);
                    break;
            }
        }
    }
}