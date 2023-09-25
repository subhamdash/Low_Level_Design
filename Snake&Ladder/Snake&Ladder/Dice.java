import java.util.Random;

public class Dice {
    private int dice;
    Random r=new Random();
    Dice(int noOfDice)
    {
        this.dice=noOfDice;
    }
    public int roll()
    {
        int bound=6*dice;
        return r.nextInt(bound-dice)+dice;
    }
}
