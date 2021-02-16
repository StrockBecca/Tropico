package character;

import game.Game;

public class Faction {
    private int memberNumber;
    private int satisfaction;

    public Faction(int memberNumber, int satisfaction){
        this.memberNumber = memberNumber;
        this.satisfaction = satisfaction;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getFactionSatisfaction(){
        return satisfaction*memberNumber;
    }
    public void setSatisfaction(int satisfaction) {
        if( this.satisfaction == 0 ){
            satisfaction = 0;
        }
        this.satisfaction = satisfaction;
    }
}
