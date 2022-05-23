import java.util.Random;

public class Flower{
    public int heal;
    Random rand = new Random();
    Flower(){

        heal = rand.nextInt(100)+1;       //healuje od 1 do 100 hp
    }
}

