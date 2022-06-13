public class Olog extends Postac{
    //atakuja tylko jak sa na tym samym polu


    private int mass;

    public void Eat_Pierogi(){};
    public void Scale_mass_to_dmg(){
        attack *= (double)mass/700;
    };


    public Olog(int x, int y){

        this.mass=rand.nextInt(500)* mass;
        this.lx=x;
        this.ly=y;
        mass = rand.nextInt(901)+100;
        this.hp=mass;
        Scale_mass_to_dmg();
    }
    public double get_attack()
    {
        return this.attack;
    }
    public void set_hp(double damage)
    {
        this.MAX_HP+=damage;
    }
    public double get_hp()
    {
        return this.hp;
    }

}
