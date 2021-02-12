package events;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEvent {
    private String[] choices;
    public MenuEvent( String[] choices ){
        this.choices = choices;
    }

    public int display( Scanner scanner ){
        int choice = 0;
        scanner = new Scanner( System.in );
        while( choice == 0 ){
            for( int i = 0; i < choices.length; i++ ){
                System.out.println( String.format("%d: %s", i+1,choices[i] ) );
            }
            System.out.print("Votre choix: ");
            try{
                choice = scanner.nextInt();
            } catch( InputMismatchException e ){
                scanner.next();
            }
            if (choice < 1 || choice > choices.length) {
                choice = 0;
                System.out.println( String.format("Merci de choisir une option entre 1 et %d",choices.length) );
            }
        }
        return choice-1;
    }
}
