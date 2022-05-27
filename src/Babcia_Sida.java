import java.util.Random;

public class Babcia_Sida{

    int x, y;
    public void wyczysc_kanwe(Postac someone){//jezeli bohater zabije okreslona (modyfikowalna) liczbe potworow i umrze, to wykonuje funkcje
        someone.hp=0;
    }
    public double love; //jak bardzo kocha bohatera - tyle daje bonus AD
    Random rand;
    Babcia_Sida(double love)
    {
        this.love = love;
    }
    public double bonus_ad()
    {
        return rand.nextInt(8)*  love;
    }

}
