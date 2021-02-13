package game;

import character.*;
import island.Agriculture;
import island.Industry;

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

    public void main(String[] args){
        Game game = Initialisation.gameInitialisation();
    }

    public void setCapitalist(Capitalist capitalist) {
        this.capitalist = capitalist;
    }

    public void setCommunist(Communist communist) {
        this.communist = communist;
    }

    public void setEnvironmentalist(Environmentalist environmentalist) {
        this.environmentalist = environmentalist;
    }

    public void setLiberals(Liberals liberals) {
        this.liberals = liberals;
    }

    public void setLoyalist(Loyalist loyalist) {
        this.loyalist = loyalist;
    }

    public void setMilitarist(Militarist militarist) {
        this.militarist = militarist;
    }

    public void setNationalist(Nationalist nationalist) {
        this.nationalist = nationalist;
    }

    public void setReligious(Religious religious) {
        this.religious = religious;
    }
}
