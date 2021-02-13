package events;

import java.util.Scanner;

public class Event {
    private String season;
    private String name;
    private String description;
    private float foodImpact;
    private float inhabitantImpact;
    private float moneyImpact;
    private float moodImpact;
    private float industryImpact;
    private float agricultureImpact;

    public Event(String season, String name, String description, float foodImpact, float inhabitantImpact,
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
    /*private String[] menu = {"oui","non"};
    private Scanner scanner;
    public void lockdown(){
        MenuEvent event = new MenuEvent(menu);
        System.out.print("Voulez-vous instaurer un confinement durant cette saison ?\n");
        int choice = event.display(scanner);
        System.out.print(menu[choice]);
    }*/
}
