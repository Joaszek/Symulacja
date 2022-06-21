public class Ork extends Postac{
    //atakuja tylko jak sa na tym samym polu

    public Ork(int lx, int ly){
        MAX_HP=rand.nextInt(20)+320;
        this.lx =lx;
        this.ly =ly;
        this.attack=rand.nextInt(40);
        this.armor=rand.nextInt(10);
        this.crit_chance=0;
        this.hp=MAX_HP;
        this.magic_resist=0;
        this.id = 4;
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



    public void DIE(){this.hp=0;}
    public void walk(Pool map[][], Ork orc) {
        super.walk(map);
        while(map[lx][ly].id!=0){       //idk jak inaczej zrobic ale dziala :D
            lx=plx;
            ly=ply;
            super.walk(map);
        }
        map[plx][ply].Orks.remove(orc);
        map[plx][ply].id=0;
        map[lx][ly].Orks.add(orc);
        map[lx][ly].id=4;
    }
}
