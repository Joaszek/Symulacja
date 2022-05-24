public class Olog extends Postac{
    //atakuja tylko jak sa na tym samym polu

    public int mass;
    public void Scale_mass_to_dmg(){
        attack *= (double)mass/1000;
    };


    Olog(){
        mass = rand.nextInt(901)+100; //od 100 do 1000 bo tak
        Scale_mass_to_dmg();
    }
}
