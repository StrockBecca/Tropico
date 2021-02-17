package island;

import character.*;
import game.Game;

import java.util.Random;

public class Agriculture extends Island {
    public Agriculture(double size) {
        super(size);
    }

    public Game checkAgriculture( Game game ){
        int totalSupporter = getTotalSupporter( game );
        int availableUnits = (int) (game.getAgriculture().getSize() * 40);
        if( availableUnits < totalSupporter * 4 ){
            System.out.print("Il n'y a pas assez d'unités de nourritures pour tous les partisans\n");
            while( totalSupporter * 4 > availableUnits ){
                decreaseSatisfaction( game );
                game = eliminateSupporters( game );
                totalSupporter = getTotalSupporter( game );
            }
            return game;
        }
        if( availableUnits > totalSupporter * 4 ){
            System.out.print("Il y a plus de nourritures que prévu !\n");
            Random rand = new Random();
            int raisePercentage = (rand.nextInt(10)+1);
            int raise = (int) (totalSupporter * (1+(raisePercentage/100)));
            for( int i = 0; i < raise; i++ ){
                game = addSupporters( game );
            }
        }
        return game;
    }
    public int getTotalSupporter( Game game ){
        return game.getCapitalist().getMemberNumber() + game.getCommunist().getMemberNumber() +
                game.getEnvironmentalist().getMemberNumber() + game.getLiberals().getMemberNumber() +
                game.getLoyalist().getMemberNumber() + game.getMilitarist().getMemberNumber() +
                game.getNationalist().getMemberNumber() + game.getReligious().getMemberNumber();
    }

    public Game addSupporters( Game game ){
        Random rand = new Random();
        int faction = rand.nextInt(8) - 1;
        switch(faction){
            case 1:
                Capitalist capitalist = game.getCapitalist();
                capitalist.setMemberNumber( capitalist.getMemberNumber() + 1 );
                break;
            case 2:
                Communist communist = game.getCommunist();
                communist.setMemberNumber( communist.getMemberNumber() + 1 );
                break;
            case 3:
                Environmentalist environmentalist = game.getEnvironmentalist();
                environmentalist.setMemberNumber( environmentalist.getMemberNumber() + 1);
                break;
            case 4:
                Liberals liberals = game.getLiberals();
                liberals.setMemberNumber( liberals.getMemberNumber() + 1);
                break;
            case 5:
                Loyalist loyalist = game.getLoyalist();
                loyalist.setMemberNumber( loyalist.getMemberNumber() + 1 );
                break;
            case 6:
                Militarist militarist = game.getMilitarist();
                militarist.setMemberNumber( militarist.getMemberNumber() + 1 );
                break;
            case 7:
                Nationalist nationalist = game.getNationalist();
                nationalist.setMemberNumber( nationalist.getMemberNumber() + 1);
                break;
            case 8:
                Religious religious = game.getReligious();
                religious.setMemberNumber( religious.getMemberNumber() + 1);
                break;
        }
        return game;
    }

    public Game eliminateSupporters( Game game ){
        Random rand = new Random();
        int faction = rand.nextInt(8) - 1;
        switch(faction){
            case 1:
                Capitalist capitalist = game.getCapitalist();
                capitalist.setMemberNumber( capitalist.getMemberNumber() - 1 );
                break;
            case 2:
                Communist communist = game.getCommunist();
                communist.setMemberNumber( communist.getMemberNumber() - 1 );
                break;
            case 3:
                Environmentalist environmentalist = game.getEnvironmentalist();
                environmentalist.setMemberNumber( environmentalist.getMemberNumber() - 1);
                break;
            case 4:
                Liberals liberals = game.getLiberals();
                liberals.setMemberNumber( liberals.getMemberNumber() - 1);
                break;
            case 5:
                Loyalist loyalist = game.getLoyalist();
                loyalist.setMemberNumber( loyalist.getMemberNumber() - 1 );
                break;
            case 6:
                Militarist militarist = game.getMilitarist();
                militarist.setMemberNumber( militarist.getMemberNumber() - 1 );
                break;
            case 7:
                Nationalist nationalist = game.getNationalist();
                nationalist.setMemberNumber( nationalist.getMemberNumber() - 1);
                break;
            case 8:
                Religious religious = game.getReligious();
                religious.setMemberNumber( religious.getMemberNumber() - 1);
                break;
        }
        return game;
    }

    public void decreaseSatisfaction( Game game ){
        Capitalist capitalist = game.getCapitalist();
        Communist communist = game.getCommunist();
        Environmentalist environmentalist = game.getEnvironmentalist();
        Liberals liberals = game.getLiberals();
        Loyalist loyalist = game.getLoyalist();
        Militarist militarist = game.getMilitarist();
        Nationalist nationalist = game.getNationalist();
        Religious religious = game.getReligious();
        capitalist.setSatisfaction(capitalist.getSatisfaction() - 2 );
        communist.setSatisfaction(communist.getSatisfaction() - 2 );
        environmentalist.setSatisfaction(environmentalist.getSatisfaction() - 2 );
        liberals.setSatisfaction( liberals.getSatisfaction() - 2 );
        loyalist.setSatisfaction( loyalist.getSatisfaction() - 2 );
        militarist.setSatisfaction( militarist.getSatisfaction() - 2 );
        nationalist.setSatisfaction( nationalist.getSatisfaction() - 2 );
        religious.setSatisfaction( religious.getSatisfaction() - 2 );

    }
}
