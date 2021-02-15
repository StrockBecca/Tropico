package game;

import character.*;
import island.Agriculture;
import island.Industry;

public class Initialisation {
    public Game gameInitialisation(  Difficulty difficulty ){

        Finances finance = new Finances(200.0);
        return new Game(difficulty, finance, new Capitalist(15, 50), new Communist(15, 50),
                        new Environmentalist(15, 50), new Liberals(15, 50), new Loyalist(15, 100),
                        new Militarist(15, 50), new Nationalist(15, 50), new Religious(15, 50),
                        new Industry(15.0), new Agriculture(15.0));
    }

    public Difficulty getDifficulty(){
        return Difficulty.selectDifficuty();
    }
}