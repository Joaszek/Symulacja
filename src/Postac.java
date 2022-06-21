import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public abstract class Postac{
    //atakuja tylko jak sa na tym samym polu
    protected Random rand = new Random(100000);
    protected int lx, ly, plx, ply;                          //koordynaty postaci na mapie (lewy gorny to 0,0);
    protected double hp;
    protected double attack=1; //tymczasowo
    protected double crit_chance;
    protected double armor;
    protected double magic_resist;
    protected double MAX_HP;
    protected int id;

    public ArrayList<Item> items;

    private void IsPool (int x, int y){};
    public abstract void Eat_Pierogi();

    public void walk(Pool map[][]){                   //chodzenie
        plx = lx;
        ply = ly;
        while(true){
            int step = rand.nextInt(8) ;        //liczba 0 odpowiada za lewe gorne pole i rosna zgodnie z kierunkiem wskazowek zegara a w mainie bedzie to zamieniane na ruch
            int [] move = {-1,-1,0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,0};
            lx += move[2*step];
            ly += move[2*step+1];
            if(lx <= 28 && ly <= 28 && lx >= 1 && ly >= 1)
            {
                    break;//konczy petle jesli nie wychodza poza skale
            }
            lx = plx; ly = ply; //przywraca lokalizacje do poczatkowej i losuje jeszcze raz
        }
    }
    public int getLx()
    {
        return this.lx;
    }
    public int getLy()
    {
        return this.ly;
    }
    public double get_attack()
    {
        return this.attack;
    }
    public void set_attack(double attack){
        this.attack = attack;
    }
    public double get_hp()
    {
        return this.hp;
    }
    public void change_hp(double change)
    {
        this.hp+= change;
    }


}
