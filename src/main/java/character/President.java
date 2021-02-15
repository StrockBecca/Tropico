package character;

import events.Event;
import game.Game;

import java.util.Random;

public class President {

    public int doEvent( Game game, int satisfaction, Event[] events ){
        Random rand = new Random();
        int event = rand.nextInt( events.length ) + 1;
        return satisfaction;
    }
}
