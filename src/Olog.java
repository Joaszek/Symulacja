public class Olog extends Postac{
    //atakuja tylko jak sa na tym samym polu


    private int mass;

    public void Eat_Pierogi(){};
    public void Scale_mass_to_dmg(){
        attack *= (double)mass/700;
    };


    public Olog(){
        this.MAX_HP=mass;
        this.mass=rand.nextInt(500)* mass;
        mass = rand.nextInt(901)+100;
        Scale_mass_to_dmg();
    }
}
