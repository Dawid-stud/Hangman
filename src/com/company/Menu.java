package com.company;

import java.util.Scanner;

public class Menu {
    private String[] menuElements;

    public Menu(String ... menuElements) {
        this.menuElements = menuElements;
    }

    private void printMenu() {
        for (int i = 0; i < menuElements.length; i++) {
            System.out.println((i+1) + ". " + menuElements[i]);
        }
    }


    public String printMenuAndGetChoice() {
        printMenu();
        Scanner scan = new Scanner(System.in);

        return menuElements[scan.nextInt() - 1];
    }
}