import java.util.ArrayList;
import java.util.Random;

//trzeba dodać gettery aby zwracały co jest w klasie Pool




public class Pool {
    int id;
    int rand;
    public boolean is_empty;
    Flower flowers;
    Item item;
    Ring ring;
    Babcia_MAD babcia_mad;
    Babcia_Sida babcia_sidas;
    ArrayList<Ring> rings;
    ArrayList<Ork> orks;
    ArrayList<Olog> ologs;
    ArrayList<Bohater> bohater;
    Random random = new Random();
    Pool()
    {
        is_empty=true;
        orks = new ArrayList<>();
        ologs = new ArrayList<>();
        bohater = new ArrayList<>();
        rings = new ArrayList<>();
    }
//z czterech metod zrobić jedną
    public boolean getbohater(){
        return bohater.isEmpty();
    }

    public boolean getork(){
        return orks.isEmpty();
    }

    public boolean getolog(){
        return ologs.isEmpty();
    }

    public boolean check()
    {
        if(getolog()||getork()||getbohater())return true;
        else
        {
            return false;
        }
    }
    public void setBabcia_mad(Babcia_MAD babcia_mad)
    {
        this.babcia_mad=babcia_mad;
    }
    //Item setting
    public Item getItem() {
        return this.item;
    }
}
