public class Bohater extends Postac implements Refuse_to_eat{
    //rusza sie jak krol w szachach
    //atakuja tylko jak sa na tym samym polu

    public int x;
    public int y;
    public void Eat(){};
    public int bonus_dmg_from_babcia;
    public int kills;
    public int look;
    public int magic;
    public boolean has_ring;
    public boolean has_babcia;
    public void magic_dmg(){};

    @Override
    public boolean Eat_or_die() {
        return false;
    }   //co?


    public Bohater(double hp, double attack, int magic, double crit_chance){       //parametry beda brane z commandline
        this.hp = hp;
        this.attack = attack;
        this.magic = magic;
        this.crit_chance = crit_chance;
        has_ring = false;
        has_babcia = false;
    }
}

