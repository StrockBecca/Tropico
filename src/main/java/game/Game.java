package game;

import character.*;
import events.Bribe;
import events.Event;
import island.Agriculture;
import island.Industry;

import java.io.FileNotFoundException;

public class Game {
    private Difficulty difficulty;
    private Finances finance;
    private Capitalist capitalist;
    private Communist communist;
    private Environmentalist environmentalist;
    private Liberals liberals;
    private Loyalist loyalist;
    private Militarist militarist;
    private Nationalist nationalist;
    private Religious religious;
    private Industry industry;
    private Agriculture agriculture;
    private static Initialisation initialize = new Initialisation();
    public Game(Difficulty difficulty, Finances finance, Capitalist capitalist, Communist communist, Environmentalist environmentalist,
                Liberals liberals, Loyalist loyalist, Militarist militarist, Nationalist nationalist, Religious religious,
                Industry industry, Agriculture agriculture){
        this.difficulty = difficulty;
        this.finance = finance;
        this.capitalist = capitalist;
        this.communist = communist;
        this.environmentalist = environmentalist;
        this.liberals = liberals;
        this.loyalist = loyalist;
        this.militarist = militarist;
        this.nationalist = nationalist;
        this.religious = religious;
        this.industry = industry;
        this.agriculture = agriculture;
    }

    public Finances getFinance() {
        return finance;
    }

    public Capitalist getCapitalist() {
        return capitalist;
    }

    public Communist getCommunist() {
        return communist;
    }

    public Environmentalist getEnvironmentalist() {
        return environmentalist;
    }

    public Liberals getLiberals() {
        return liberals;
    }

    public Loyalist getLoyalist() {
        return loyalist;
    }

    public Militarist getMilitarist() {
        return militarist;
    }

    public Nationalist getNationalist() {
        return nationalist;
    }

    public Religious getReligious() {
        return religious;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Agriculture getAgriculture() {
        return agriculture;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int season = 1;
        President president = new President();
        Difficulty difficulty = initialize.getDifficulty();
        Game game = initialize.gameInitialisation( difficulty );
        float satisfaction = getTotalSatisfaction(game);
        while ( satisfaction > difficulty.getMinSatisfaction() ){
                Event[] events = Event.getEventByDifficulty( difficulty, season );
                game = president.doEvent( game, events, season );
                satisfaction = getTotalSatisfaction(game);
                System.out.print("Satisfaction: "+satisfaction + "\n");
            if ( season%4 == 0 ){
                System.out.println( String.format("Saison: %d",season) );
                season = 0;
                Bribe bribe = new Bribe();
                bribe.callBribe(game);
            }
            season += 1;
        }
    }

    public static float getTotalSatisfaction(Game game){
        float numerator = game.capitalist.getFactionSatisfaction()+game.communist.getFactionSatisfaction()+
                game.environmentalist.getFactionSatisfaction()+game.liberals.getFactionSatisfaction()+
                game.religious.getFactionSatisfaction()+game.militarist.getFactionSatisfaction()+
                game.nationalist.getFactionSatisfaction()+game.loyalist.getFactionSatisfaction();

        float denominator = game.capitalist.getMemberNumber() + game.communist.getMemberNumber()+
                game.environmentalist.getMemberNumber() + game.liberals.getMemberNumber() +
                game.religious.getMemberNumber() + game.militarist.getMemberNumber() +
                game.nationalist.getMemberNumber()+ game.loyalist.getMemberNumber();

        return numerator/denominator;
    }

}
