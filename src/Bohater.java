public class Bohater extends Postac {
    //rusza sie jak krol w szachach
    //atakuja tylko jak sa na tym samym polu
    //nie zrobiony

    private int bonus_dmg_from_babcia;
    private int kills;
    private int look;
    protected double magic;
    private boolean has_ring;
    private boolean has_babcia;
    private void Eat(){};
    private void magic_dmg(){};
    public void Eat_Pierogi(){}


    public boolean Eat_or_die() {
        return false;
    }   //co? generalnie ten interfejs byl bez sensu


    public Bohater(double hp, double attack, double magic, double crit_chance){
        this.MAX_HP=hp;//parametry beda brane z commandline
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.crit_chance = crit_chance;
        has_ring = false;
        has_babcia = false;
        this.kills=0;
        this.id = 1;
    }


    public void walk(Pool map[][], Bohater pepe) {
        super.walk(map);
        map[lx][ly].bohater.clear();
        map[plx][ply].id=0;
        map[lx][ly].bohater.add(pepe);
        try{
            Thread.sleep(100);                  //tylko tu zeby ruch nie trwal 200 sekund ani 0
        }
        catch (InterruptedException e)
        {
        }

    }

    // public void fight(){};


    public int getKills()
    {
        return kills;
    }
    public int getBonus_dmg_from_babcia() {
        return bonus_dmg_from_babcia;
    }
    public void set_bonus_attack(double bonus) {this.attack += bonus;}
    public void setHas_babcia(){this.has_babcia=true;}
    public void addKill()
    {
        this.kills++;
    }
    public void set_hp(double hp){this.hp = hp;}
}

