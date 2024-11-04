package de.ostfalia.gdp.ws24.s4;

import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class LieblingsZeichen {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        Variables variables = new Variables();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != ' ') {
                count(currentChar, input.length(), input, variables);
            }

        }

        System.out.print("--Ranking der Zeichen--\n");
        System.out.print(variables.firstChar + " = " + variables.firstPlace + "\n");
        System.out.print(variables.secondChar + " = " + variables.secondPlace + "\n");
        System.out.print(variables.thirdChar + " = " + variables.thirdPlace + "\n");
    }

    public static void count(char pos, int length, String input, Variables variables) {
        short amount = 0;

        boolean alreadyCounted = (toLowerCase(pos) == toLowerCase(variables.firstChar)) || (toLowerCase(pos) == toLowerCase(variables.secondChar)) || (toLowerCase(pos) == toLowerCase(variables.thirdChar));

        if (!alreadyCounted) {
            for (int i = 0; i < length; i++) {
                if (input.charAt(i) == pos) {
                    amount += 1;
                }
            }
            if (amount > variables.firstPlace) {
                variables.thirdPlace = variables.secondPlace;
                variables.thirdChar = variables.secondChar;
                variables.secondPlace = variables.firstPlace;
                variables.secondChar = variables.firstChar;
                variables.firstPlace = amount;
                variables.firstChar = pos;
            } else if (amount > variables.secondPlace) {
                variables.thirdPlace = variables.secondPlace;
                variables.thirdChar = variables.secondChar;
                variables.secondPlace = amount;
                variables.secondChar = pos;
            } else if (amount > variables.thirdPlace) {
                variables.thirdPlace = amount;
                variables.thirdChar = pos;
            }
        }
    }
}

class Variables {
    char firstChar = 0;
    char secondChar = 0;
    char thirdChar = 0;
    short firstPlace = 0;
    short secondPlace = 0;
    short thirdPlace = 0;
}
