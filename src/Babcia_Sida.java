import java.util.Random;

public class Babcia_Sida{

    private Random rand = new Random();
    private int x, y;
    public double love; //jak bardzo kocha bohatera - tyle daje bonus AD
    public void wyczysc_kanwe(Postac someone){//jezeli bohater zabije okreslona (modyfikowalna) liczbe potworow i umrze, to wykonuje funkcje
        someone.hp=0;
    }
    Babcia_Sida()
    {
        this.love = 60*rand.nextDouble();   //60 bo tak
    }
    public double bonus_ad()
    {
        return rand.nextInt(8)*  love;
    }


    public void SetX(int x){
        this.x = x;
    }
    public void SetY(int y){
        this.y = y;
    }
}
