package island;

import events.Event;
import game.Difficulty;
import game.Game;

public class Island {
    private double size;
    public Island(double size){

        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        if( size <= 0 ){
            size = 0;
        }
        this.size = size;
    }

}

