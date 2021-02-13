package game;

public class Game {
    private Difficulty difficulty;

    public Game(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public void main(String[] args){
        Difficulty difficulty = Difficulty.selectDifficuty();
    }
}
