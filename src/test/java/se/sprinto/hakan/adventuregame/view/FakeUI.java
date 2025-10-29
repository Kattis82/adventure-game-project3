package se.sprinto.hakan.adventuregame.view;

import java.util.Scanner;

// testimplementations-klass av interfacet UI

public class FakeUI implements UI {

    // lagrar fejkad användarinmatning

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    // kan lämnas tom eftersom man inte behöver se utskrifter vid test
        @Override
        public void showMessage(String message) {
            //System.out.println(message);
        }

        @Override
        public String getInput(String prompt) {
            System.out.println(prompt);
            return input;
            //return scanner.nextLine();
        }
    }

