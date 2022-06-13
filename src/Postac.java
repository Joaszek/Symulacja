import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public abstract class Postac{
    //atakuja tylko jak sa na tym samym polu
    protected Random rand = new Random(100000);
    public int lx, ly;                          //koordynaty postaci na mapie (lewy gorny to 0,0);
    protected double hp;
    protected double attack=1; //tymczasowo
    protected double crit_chance;
    protected double armor;
    protected double magic_resist;
    protected double MAX_HP;

    public ArrayList<Item> items;

    private void IsPool (int x, int y){};
    public abstract void Eat_Pierogi();

    public void walk(Pool pools[][],Pool pool){
        //chodzenie

        int a = lx;
        int b = ly;
        int verse=check_bounds(pools);
        int i=0;

        while(true){

            //if(verse==3)break;
            int step = rand.nextInt(8) ;   //liczba 0 odpowiada za lewe gorne pole i rosna zgodnie z kierunkiem wskazowek zegara a w mainie bedzie to zamieniane na ruch
            int [] move = {-1,-1,0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,0};
            lx += move[2*step];
            ly += move[2*step+1];

            try{
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {

            }



            if(lx <= 28 && ly <= 28 && lx >= 1 && ly >= 1)
            {
               // if(pools[lx][ly].check()) {
                    break;//konczy petle jesli nie wychodza poza skale
                //}
            }
            lx = a; ly = b; //przywraca lokalizacje do poczatkowej i losuje jeszcze raz

        }

    }
    public void fight(){};
    public int getLx()
    {
        return this.lx;
    }
    public int getLy()
    {
        return this.ly;
    }

    private int check_bounds(Pool[][] pools)
    {
        int verse=0;
        if(!pools[lx-1][ly-1].check()&&!pools[lx-1][ly].check()&&!pools[lx-1][ly+1].check())
        {
            verse++;
        }
        if(!pools[lx][ly-1].check()&&!pools[lx-1][ly+1].check())
        {
            verse++;
        }
        if(!pools[lx+1][ly-1].check()&&!pools[lx+1][ly].check()&&!pools[lx+1][ly+1].check())
        {
            verse++;
        }
        return verse;
    }
}
