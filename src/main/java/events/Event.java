package events;

import java.util.Scanner;

public class Event {
    private String[] menu = {"oui","non"};
    private Scanner scanner;
    public void lockdown(){
        MenuEvent event = new MenuEvent(menu);
        System.out.print("Voulez-vous instaurer un confinement durant cette saison ?\n");
        int choice = event.display(scanner);
        System.out.print(menu[choice]);
    }
}
