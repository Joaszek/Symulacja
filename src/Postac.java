import java.util.ArrayList;
import java.util.Random;

public abstract class Postac{
    //atakuja tylko jak sa na tym samym polu
    protected Random rand = new Random();
    protected int lx, ly;                          //koordynaty postaci na mapie (lewy gorny to 0,0);
    protected double hp;
    protected double attack=1; //tymczasowo
    protected double crit_chance;
    protected double armor;
    protected double magic_resist;
    protected double MAX_HP;

    public ArrayList<Item> items;

    private void IsPool (int x, int y){};
    public abstract void Eat_Pierogi();

    public void walk() {                 //chodzenie
        int a = lx;
        int b = ly;
        while(true){
            int step = rand.nextInt(8) ;   //liczba 0 odpowiada za lewe gorne pole i rosna zgodnie z kierunkiem wskazowek zegara a w mainie bedzie to zamieniane na ruch
            int [] move = {-1,-1,0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,0};
            lx += move[2*step];
            ly += move[2*step+1];
            if(lx <= 29 && ly <= 29 && lx >= 0 && ly >= 0) break;    //konczy petle jesli nie wychodza poza skale
            else{
                lx = a; ly = b;};                                   //przywraca lokalizacje do poczatkowej i losuje jeszcze raz
        }
    }
    public void fight(){};
}
