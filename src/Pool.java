import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.Flow;

//trzeba dodać gettery aby zwracały co jest w klasie Pool




public class Pool {
    Flower flowers;
    Item items;
    Ork orks;
    Olog ologs;
    Pierscien pierscien;
    Babcia_MAD babcia_mads;
    Babcia_Sida babcia_sidas;
    public boolean is_empty;
    Pool()
    {
        is_empty=true;
    }

    ArrayList<Ork> Orks = new ArrayList<>();
    //ologow tez
    ArrayList<Bohater> bohater = new ArrayList<>();

    public void set_Orks()
    {
        is_empty=false;
    }
    public void set_Ologs()
    {
        is_empty=false;
    }
    public void set_Flowers()
    {
        is_empty=false;
    }
    public void set_Babcia_MAD()
    {
        is_empty=false;
    }
    public void set_Items()
    {
        is_empty=false;
    }
    public void set_Bohater()
    {
        is_empty=false;
    }
}
