package events;

import character.*;
import game.Finances;
import game.Game;

import java.util.Scanner;

public class Bribe {
    private Scanner scanner;

    public void callBribe(Game game){
        System.out.println("Voulez-vous versez un pot de vin?");
        String[] choices = { "oui", "non" };
        MenuEvent displayEvent = new MenuEvent(choices);
        int choice = displayEvent.display(scanner);
        if(choice == 1){
            chooseFactionToBribe(game);
        }
    }

    private void chooseFactionToBribe(Game game) {
        String[] choices = { "Capitaliste", "Communiste", "Ecologiste", "Libéraux", "Militariste", "Nationaliste", "Religieux" };
        MenuEvent displayEvent = new MenuEvent(choices);
        int choice = displayEvent.display(scanner);
        int bribeAmount = 0;
        switch(choice){
            case 1:
                Capitalist capitalist = game.getCapitalist();
                bribeAmount = capitalist.getMemberNumber() * 15;
                break;
            case 2:
                Communist communist = game.getCommunist();
                bribeAmount = communist.getMemberNumber() * 15;
                break;
            case 3:
                Environmentalist environmentalist = game.getEnvironmentalist();
                bribeAmount = environmentalist.getMemberNumber() * 15;
                break;
            case 4:
                Liberals liberals = game.getLiberals();
                bribeAmount = liberals.getMemberNumber() * 15;
                break;
            case 5:
                Militarist militarist = game.getMilitarist();
                bribeAmount = militarist.getMemberNumber() * 15;
                break;
            case 6:
                Nationalist nationalist = game.getNationalist();
                bribeAmount = nationalist.getMemberNumber() * 15;
                break;
            case 7:
                Religious religious = game.getReligious();
                bribeAmount = religious.getMemberNumber() * 15;
                break;
        }
        validationBribe(bribeAmount, choice, game);
        callBribe(game);
    }

    private void validationBribe(int bribeAmount, int faction, Game game) {
        System.out.println( String.format("Vous devrez payer " + bribeAmount));
        String[] choices = { "oui", "non" };
        MenuEvent displayEvent = new MenuEvent(choices);
        int choice = displayEvent.display(scanner);
        double gameFinances = game.getFinance().getAmount() - bribeAmount;
        if(choice == 1 && gameFinances >= 0){
            switch (faction) {
                case 1:
                    bribeCapitalist(game, gameFinances);
                    break;
                case 2:
                    bribeCommunist(game, gameFinances);
                    break;
                case 3:
                    bribeEnvironmentalist(game, gameFinances);
                    break;
                case 4:
                    bribeLiberals(game, gameFinances);
                    break;
                case 5:
                    bribeMilitarist(game, gameFinances);
                    break;
                case 6:
                    bribeNationalist(game, gameFinances);
                    break;
                case 7:
                    bribeReligious(game, gameFinances);
                    break;
            }
            System.out.println( String.format("Il vous reste maintenant " + gameFinances + "€"));
            loyalistEffect(bribeAmount, game);
        } else if(gameFinances <= 0){
            System.out.println("Vous n'avez pas assez d'argent pour verser un pot de vin à cette faction.");
        }
    }

    public void bribeCapitalist(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getCapitalist().setSatisfaction((int) (game.getCapitalist().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des capitalist est passé à " + game.getCapitalist().getSatisfaction()));
    }

    public void bribeCommunist(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getCommunist().setSatisfaction((int) (game.getCommunist().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des communist est passé à " + game.getCommunist().getSatisfaction()));
    }

    public void bribeEnvironmentalist(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getEnvironmentalist().setSatisfaction((int) (game.getEnvironmentalist().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des environmentalist est passé à " + game.getEnvironmentalist().getSatisfaction()));
    }

    private void bribeLiberals(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getLiberals().setSatisfaction((int) (game.getLiberals().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des liberals est passé à " + game.getLiberals().getSatisfaction()));
    }

    private void bribeMilitarist(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getMilitarist().setSatisfaction((int) (game.getMilitarist().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des militarist est passé à " + game.getMilitarist().getSatisfaction()));
    }

    private void bribeNationalist(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getNationalist().setSatisfaction((int) (game.getNationalist().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des nationalist est passé à " + game.getNationalist().getSatisfaction()));
    }

    private void bribeReligious(Game game, double gameFinances) {
        game.getFinance().setAmount((float) gameFinances);
        game.getReligious().setSatisfaction((int) (game.getReligious().getSatisfaction() * 1.1));
        System.out.println( String.format("La satisfaction des religious est passé à " + game.getReligious().getSatisfaction()));
    }

    public void loyalistEffect(float amount, Game game){
        int unsatisfaction = (int) (amount / 10);
        int satisfaction = game.getLoyalist().getSatisfaction();
        game.getLoyalist().setSatisfaction(satisfaction - unsatisfaction);
        System.out.println( String.format("La satisfaction des loyalistes est descendu à " + game.getLoyalist().getSatisfaction()));
    }

}
