import java.util.ArrayList;
import java.util.Random;

public abstract class Postac{
    //atakuja tylko jak sa na tym samym polu

    Random rand = new Random();
    public String name;
    public double hp;
    public double attack=1; //tymczasowo
    public double crit_chance;
    public ArrayList<Item> items;
    public void Eat_Pierogi(){};
    public double armor;
    public double magic_resist;
    public void IsPool (int x, int y){};
    public double MAX_HP;
    int Lx, Ly;                          //koordynaty gracza na tablicy (lewy gorny to 0,0)
    public void walk() {                 //chodzenie
        int a = Lx;
        int b = Ly;
        while(true){
            int krok = rand.nextInt(8) + 1;   //liczba 1 odpowiada za lewe gorne pole i rosna zgodnie z kierunkiem wskazowek zegara a w mainie bedzie to zamieniane na ruch
            switch (krok) {                           //chyba jest debiloodporne
                case 1:
                    Lx -= 1;
                    Ly -= 1;
                    break;
                case 2:
                    Ly -= 1;
                    break;
                case 3:
                    Lx += 1;
                    Ly -= 1;
                    break;
                case 4:
                    Lx += 1;
                    break;
                case 5:
                    Lx += 1;
                    Ly += 1;
                    break;
                case 6:
                    Ly += 1;
                    break;
                case 7:
                    Lx -= 1;
                    Ly += 1;
                    break;
                case 8:
                    Lx -= 1;
                    break;
            };
            if(Lx <= 29 && Ly <= 29 && Lx >= 0 && Ly >= 0) break;    //konczy petle jesli nie wychodza poza skale
            else{Lx = a; Ly = b;};                                   //przywraca lokalizacje do poczatkowej i losuje jeszcze raz
        }
    }
    public void fight(){};
}
