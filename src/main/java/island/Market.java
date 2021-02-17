package island;

import events.MenuEvent;
import game.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Market {
    private String[] choices = { "oui", "non" };
    private Scanner scanner = new Scanner( System.in );
    public Game foodMart( Game game  ){
        MenuEvent menu = new MenuEvent( choices );
        System.out.println("Voulez vous acheter des unités de nourritures à 8€ l'unité ?\n");
        System.out.println(String.format("Vous disposez actuellement de %d unités et de %.2f€",(int)game.getAgriculture().getSize()*40,game.getFinance().getAmount() ));
        int choice = menu.display( scanner );
        if( choice == 1 ){
            int units = 0;
            while( units == 0 ){
                System.out.print("Combien d'unités voulez-vous ? ");
                try{
                    units = scanner.nextInt();
                } catch ( InputMismatchException e ){
                    scanner.next();
                }
                if( units < 1 || units > game.getFinance().getAmount()/8 ){
                    System.out.println( String.format( "Veuillez entrez un chiffre entre 1 et %d", (int)game.getFinance().getAmount()/8));
                    units = 0;
                }
            }
            game.getAgriculture().setSize(game.getAgriculture().getSize()+units);
            game.getFinance().setAmount((float) (game.getFinance().getAmount() - units*8));
        }
        return game;
    }
}
