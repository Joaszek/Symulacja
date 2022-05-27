public class Ork extends Postac{
    //atakuja tylko jak sa na tym samym polu

    public double skill_issue;      //co to robilo? obnizalo czy negowalo zadane dmg?
    public int chance_to_see;


    Ork(int Lx, int Ly){
        MAX_HP=rand.nextInt(20)+320;
        skill_issue = rand.nextDouble(50);        //losuje od 0 do 1;
        skill_issue+=50;
        chance_to_see = rand.nextInt(101);//szansa na zobaczenie I guess
        this.Lx=Lx;
        this.Ly=Ly;
        this.attack=rand.nextInt(40);
        this.armor=rand.nextInt(10);
        this.crit_chance=0;
        this.hp=MAX_HP;
        this.magic_resist=0;
    }

    @Override
    public void Eat_Pierogi() {
        this.hp=MAX_HP;
    }


    public void get_dmg(double dmg)
    {
        this.hp-=dmg;
    }
    public double do_dmg()
    {
        return attack;
    }
}
