package game;

import java.util.Scanner;

public class Difficulty {
    private String level;
    private int minSatisfaction;


    public Difficulty(String level, int minSatisfaction){
        this.level = level;
        this.minSatisfaction = minSatisfaction;
    }

    public static Difficulty selectDifficuty(){
        Scanner input = new Scanner(System.in);
        System.out.print("Avec quelle difficulté voulez-vous jouer ?\n 1 - Facile\n 2 - Normal\n 3 - Difficile\n");
        String choiceString = input.nextLine();
        int choice = Integer.parseInt(choiceString) ;

        switch( choice ) {
            case 1:
                return new Difficulty("Facile", 10);
            case 2:
                return new Difficulty("Normal", 30);
            case 3:
                return new Difficulty("Difficle", 50);
            default:
                Difficulty difficulty = selectDifficuty();
                return difficulty;
        }
    }
}
