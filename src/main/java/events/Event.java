package events;

import game.Difficulty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Event {
    private String season;
    private String name;
    private String description;
    private float capitalistImpact;
    private float communistImpact;
    private float environmentalistImpact;
    private float liberalImpact;
    private float loyalistImpact;
    private float militaristImpact;
    private float nationalistImpact;
    private float religiousImpact;
    private float moneyImpact;
    private float industryImpact;
    private float agricultureImpact;

    public Event(String season, String name, String description,
                 float capitalistImpact, float communistImpact,
                 float environmentalistImpact, float liberalImpact,
                 float loyalistImpact, float militaristImpact,
                 float nationalistImpact, float religiousImpact,
                 float moneyImpact, float industryImpact,
                 float agricultureImpact) {
        this.season = season;
        this.name = name;
        this.description = description;
        this.capitalistImpact = capitalistImpact;
        this.communistImpact = communistImpact;
        this.environmentalistImpact = environmentalistImpact;
        this.liberalImpact = liberalImpact;
        this.loyalistImpact = loyalistImpact;
        this.militaristImpact = militaristImpact;
        this.nationalistImpact = nationalistImpact;
        this.religiousImpact = religiousImpact;
        this.moneyImpact = moneyImpact;
        this.industryImpact = industryImpact;
        this.agricultureImpact = agricultureImpact;
    }

    public static Event eventFromFile(String event){
        String[] fields = event.split("\\|");
        String season = fields[0];
        String name = fields[1];
        String description = fields[2];
        Float capitalistImpact = Float.parseFloat(fields[3]);
        Float communistImpact = Float.parseFloat(fields[4]);
        Float environmentalistImpact = Float.parseFloat(fields[5]);
        Float liberalImpact = Float.parseFloat(fields[6]);
        Float loyalistImpact = Float.parseFloat(fields[7]);
        Float militaristImpact = Float.parseFloat(fields[8]);
        Float nationalistImpact = Float.parseFloat(fields[9]);
        Float religiousImpact = Float.parseFloat(fields[10]);
        Float moneyImpact = Float.parseFloat(fields[11]);
        Float industryImpact = Float.parseFloat(fields[12]);
        Float agricultureImpact = Float.parseFloat(fields[13]);
        return new Event( season, name, description, capitalistImpact, communistImpact, environmentalistImpact
        , liberalImpact, loyalistImpact, militaristImpact, nationalistImpact, religiousImpact,
                moneyImpact, industryImpact, agricultureImpact);
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getCapitalistImpact() {
        return capitalistImpact;
    }

    public float getCommunistImpact() {
        return communistImpact;
    }

    public float getEnvironmentalistImpact() {
        return environmentalistImpact;
    }

    public float getLiberalImpact() {
        return liberalImpact;
    }

    public float getLoyalistImpact() {
        return loyalistImpact;
    }

    public float getMilitaristImpact() {
        return militaristImpact;
    }

    public float getNationalistImpact() {
        return nationalistImpact;
    }

    public float getReligiousImpact() {
        return religiousImpact;
    }

    public float getMoneyImpact() {
        return moneyImpact;
    }

    public float getIndustryImpact() {
        return industryImpact;
    }

    public float getAgricultureImpact() {
        return agricultureImpact;
    }
}
