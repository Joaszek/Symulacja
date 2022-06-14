import java.util.Random;

public class Babcia_MAD {
    public static void feed(Postac someone){
        Random rand = new Random();
        if(rand.nextInt()%14 == 0){      //co 14 bo tak xd
            someone.hp = 0;
        }
        else{
            someone.hp= someone.MAX_HP;
        }
    };   //leczy do max HP, jesli zje, w przeciwnym wypadku zabija
}
