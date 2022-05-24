import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Flow;

//trzeba dodać gettery aby zwracały co jest w klasie Pool




public class Pool {
    Flower flowers;
    Item items;
    Pierscien pierscien;
    Babcia_MAD babcia_mads;
    Babcia_Sida babcia_sidas;
    ArrayList<Ork> Orks;
    ArrayList<Olog> Ologs;
    ArrayList<Bohater> bohater;
    int id;
    int rand;
    Random random = new Random();
    public boolean is_empty;
    Pool()
    {
        is_empty=true;
        Orks = new ArrayList<>();
        Ologs = new ArrayList<>();
        bohater = new ArrayList<>();
    }

    public boolean getbohater(){
        return bohater.isEmpty();
    }

    public boolean getork(){
        return Orks.isEmpty();
    }

    public boolean getolog(){
        return Ologs.isEmpty();
    }





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

   /* public void ktoTo(){

    }*/

    public int get_rand()
    {
        rand = random.nextInt(8);
        return rand;
    }
}
