package character;

import events.Event;
import events.MenuEvent;
import game.Game;

import java.util.Random;
import java.util.Scanner;

public class President {
    private String[] choices = { "oui", "non" };
    private Scanner scanner;

    public Game doEvent( Game game, Event[] events ){
        Random rand = new Random();
        MenuEvent displayEvent = new MenuEvent(choices);
        int event = rand.nextInt( events.length ) + 1;
        System.out.println( String.format("%s\n%s", events[event-1].getName(),events[event-1].getDescription()));
        int choice = displayEvent.display(scanner);

        if( choice == 1 ){
            game.getCapitalist().setSatisfaction((int) (game.getCapitalist().getSatisfaction() + events[event - 1].getCapitalistImpact()));
            game.getCommunist().setSatisfaction((int) (game.getCommunist().getSatisfaction() + events[event - 1].getCapitalistImpact()));
            game.getEnvironmentalist().setSatisfaction((int) (game.getEnvironmentalist().getSatisfaction() + events[event - 1].getEnvironmentalistImpact()));
            game.getLiberals().setSatisfaction((int) (game.getLiberals().getSatisfaction() + events[event - 1].getLiberalImpact()));
            game.getLoyalist().setSatisfaction((int) (game.getLoyalist().getSatisfaction() + events[event - 1].getLoyalistImpact()));
            game.getMilitarist().setSatisfaction((int) (game.getMilitarist().getSatisfaction() + events[event - 1].getMilitaristImpact()));
            game.getNationalist().setSatisfaction((int) (game.getNationalist().getSatisfaction() + events[ event - 1].getNationalistImpact()));
            game.getReligious().setSatisfaction((int) (game.getReligious().getSatisfaction() + events[ event - 1 ].getReligiousImpact()));
            game.getFinance().setAmount((float) (game.getFinance().getAmount() + events[ event - 1 ].getMoneyImpact()));
            game.getIndustry().setSize( game.getIndustry().getSize() + events[ event - 1 ].getIndustryImpact() );
            game.getAgriculture().setSize( game.getAgriculture().getSize() + events[ event - 1 ].getAgricultureImpact() );
        }
        System.out.print("\n\n");
        return game;
    }
}
