public class Ork extends Postac{
    //atakuja tylko jak sa na tym samym polu

    public Ork(int lx, int ly){
        MAX_HP=rand.nextInt(20)+320;
        this.lx =lx;
        this.ly =ly;
        this.attack=rand.nextInt(40);
        this.armor=rand.nextInt(10);
        this.hp=MAX_HP;
        this.id = 4;
    }
    public void DIE(){this.hp=0;}
    public void walk(Pool map[][], Ork orc) {
        super.walk(map);
        while(map[lx][ly].id!=0){       //idk jak inaczej zrobic ale dziala :D
            lx=plx;
            ly=ply;
            super.walk(map);
        }
        map[plx][ply].orks.remove(orc);
        map[plx][ply].id=0;
        map[lx][ly].orks.add(orc);
        map[lx][ly].id=4;
    }
}
