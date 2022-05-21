import java.util.ArrayList;

public abstract class Postac {
    //atakuja tylko jak sa na tym samym polu

    public String name;
    public double hp;
    public double attack;
    public double crit_chance;
    public ArrayList<Item> items;
    public void fight(){};
    public void walk(){};
    public void Eat_Pierogi(){};
    public double armor;
    public double magic_resist;
    public int range;
}
