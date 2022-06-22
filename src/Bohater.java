public class Bohater extends Postac {
    //rusza sie jak krol w szachach
    //atakuja tylko jak sa na tym samym polu
    //nie zrobiony

    private int bonus_dmg_from_babcia;
    private int kills;
    private boolean has_ring;
    private boolean has_babcia;//?

    public Bohater(double hp){
        this.MAX_HP=hp;//parametry beda brane z commandline
        has_ring = false;
        has_babcia = false;
        this.kills=0;
        this.id = 1;
    }


    public void walk(Pool map[][], Bohater pepe) {
        super.walk(map);
        map[plx][ply].bohater.clear();
        map[plx][ply].id=0;
        map[lx][ly].bohater.add(pepe);
        try{
            Thread.sleep(100);                  //tylko tu zeby ruch nie trwal 200 sekund ani 0
        }
        catch (InterruptedException e)
        {
        }

    }

    // public void fight(){};           XD

    public int getKills()
    {
        return kills;
    }
    public void set_bonus_attack(double bonus) {this.attack += bonus;}
    public void addKill()
    {
        this.kills++;
    }
    public void set_hp(double hp){this.hp = hp;}
    public boolean isHas_ring(){return has_ring;}
    public void setHas_ring(){has_ring = true;}
}

