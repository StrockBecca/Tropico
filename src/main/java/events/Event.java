package events;

import game.Difficulty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Event {
    private String season;
    private String name;
    private String description;
    private float foodImpact;
    private int inhabitantImpact;
    private float moneyImpact;
    private float moodImpact;
    private float industryImpact;
    private float agricultureImpact;

    public Event(String season, String name, String description, float foodImpact, int inhabitantImpact,
                 float moneyImpact, float moodImpact, float industryImpact, float agricultureImpact){
        this.season = season;
        this.name = name;
        this.description = description;
        this.foodImpact = foodImpact;
        this.inhabitantImpact = inhabitantImpact;
        this.moneyImpact = moneyImpact;
        this.moodImpact = moodImpact;
        this.industryImpact = industryImpact;
        this.agricultureImpact = agricultureImpact;
    }

    public static Event eventFromFile(String event){
        String[] fields = event.split("\\|");
        String season = fields[0];
        String name = fields[1];
        String description = fields[2];
        Float foodImpact = Float.parseFloat(fields[3]);
        int inhabitantImpact = Integer.parseInt(fields[4]);
        Float moneyImpact = Float.parseFloat(fields[5]);
        Float moodImpact = Float.parseFloat(fields[6]);
        Float industryImpact = Float.parseFloat(fields[7]);
        Float agricultureImpact = Float.parseFloat(fields[8]);
        return new Event( season, name, description, foodImpact, inhabitantImpact, moneyImpact,moodImpact,industryImpact,agricultureImpact);
    }

    public static Event[] loadEvents(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = countLines( file );
        Event[] events = new Event[lines];
        for( int i = 0; i < lines; i++ ){
            events[i] = eventFromFile(scanner.nextLine() );
        }
        return events;
    }

    public static Event[] getEventByDifficulty( Difficulty difficulty ) throws FileNotFoundException {

        if ( difficulty.getLevel().equals("Facile") ){
            File easy = new File("EasyEvent.txt");
            return loadEvents(easy);
        }
        if( difficulty.getLevel().equals("Normal") ){
            File medium = new File( "MediumEvent.txt" );
            return loadEvents( medium );
        }
        if( difficulty.getLevel().equals("Difficile") ){
            File hard = new File( "HardEvent.txt");
            return loadEvents( hard );
        }

        return new Event[0];
    }

    public static int countLines( File file ) {
        int lines = 0;
        try {
            Scanner countFile = new Scanner(file);
            while( countFile.hasNext() ) {
                lines+=1;
                countFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
