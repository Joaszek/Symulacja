import java.util.ArrayList;
import java.util.Random;

public class Babcia_Sida{

    private Random rand = new Random();
    private int x, y;
    public double love; //jak bardzo kocha bohatera - tyle daje bonus AD
    public void wyczysc_kanwe(ArrayList<Olog> ologi, ArrayList<Ork> orks,Pool [][]map){
        //jezeli bohater zabije okreslona (modyfikowalna) liczbe potworow i umrze, to wykonuje funkcje
        for(Olog olog:ologi)
        {
            olog.DIE();
        }
        for(Ork ork:orks)
        {
            ork.DIE();
        }
        for(int i=1;i<29;i++)
        {
            for(int j=1;j<29;j++)
            {
                if(map[i][j].id==5||map[i][j].id==4)
                {
                    map[i][j].id=0;
                }
            }
        }
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
