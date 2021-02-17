package game;

public class Finances {
    private double amount;

    public Finances(double amount){
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        if( amount <= 0 ){
            amount = 0;
        }
        this.amount = amount;
    }
}
