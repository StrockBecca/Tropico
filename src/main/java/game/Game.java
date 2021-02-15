package game;

import character.*;
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


    public static void main(String[] args) throws FileNotFoundException {
        int season = 0;
        int satisfaction = 0;
        President president = new President();
        Difficulty difficulty = initialize.getDifficulty();
        Game game = initialize.gameInitialisation( difficulty );
        Event[] events = Event.getEventByDifficulty( difficulty );
        while ( satisfaction > difficulty.getMinSatisfaction() ){
                satisfaction = president.doEvent( game, satisfaction, events );
            if ( season%4 == 0 && season != 0 ){

            }
            season += 1;
        }
    }

}
