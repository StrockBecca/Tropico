package island;

import events.Event;
import game.Difficulty;
import game.Game;
import game.Initialisation;

public class Island {
    private double size;
    private static Initialisation initialize = new Initialisation();
    public Island(double size){

        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

