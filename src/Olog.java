public class Olog extends Postac {
    //atakuja tylko jak sa na tym samym polu


    private int mass;
    private int verse;

    public void Eat_Pierogi() {
    }

    ;

    public void Scale_mass_to_dmg() {
        attack *= (double) mass / 700;
    }




    public Olog(int x, int y) {

        this.id = 5;
        this.lx = x;
        this.ly = y;
        this.mass = rand.nextInt(901) + 100;
        this.hp = mass;
        Scale_mass_to_dmg();
    }


    public void DIE() {
        this.hp = 0;
    }

    public void walk(Pool map[][], Olog olog) {
        super.walk(map);
        while(map[lx][ly].id!=0){
            lx=plx;
            ly=ply;
            super.walk(map);
        }
        map[plx][ply].Ologs.remove(olog);
        map[plx][ply].id=0;
        map[lx][ly].Ologs.add(olog);
        map[lx][ly].id=5;
    }
}



