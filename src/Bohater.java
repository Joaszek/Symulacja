public class Bohater extends Postac {
    //rusza sie jak krol w szachach
    //atakuja tylko jak sa na tym samym polu
    //nie zrobiony
    public int x;
    public int y;
    private int bonus_dmg_from_babcia;
    private int kills;
    private int look;
    private int magic;
    private boolean has_ring;
    private boolean has_babcia;
    private void Eat(){};
    private void magic_dmg(){};
    public void Eat_Pierogi(){};


    public boolean Eat_or_die() {
        return false;
    }   //co? generalnie ten interfejs byl bez sensu


    public Bohater(double hp, double attack, int magic, double crit_chance){
        this.MAX_HP=hp;//parametry beda brane z commandline
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.crit_chance = crit_chance;
        has_ring = false;
        has_babcia = false;
    }
}

