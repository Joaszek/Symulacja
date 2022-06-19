public class Olog extends Postac{
    //atakuja tylko jak sa na tym samym polu


    private int mass;
    private int verse;
    public void Eat_Pierogi(){};
    public void Scale_mass_to_dmg(){
        attack *= (double)mass/700;
    };


    public Olog(int x, int y){

        this.lx=x;
        this.ly=y;
        this.mass= rand.nextInt(901)+100;
        this.hp=mass;
        Scale_mass_to_dmg();
    }
    public double get_attack()
    {
        return this.attack;
    }
    public void set_hp(double damage)
    {
        this.hp+=damage;
    }
    public double get_hp()
    {
        return this.hp;
    }
    public void DIE(){this.hp=0;}
    int getVerse()
    {
        return verse;
    }
    public void walk_stwory(Pool[][] pools)
    {
        int a = lx;
        int b = ly;
        verse=check_bounds(pools,lx,ly);
        int i=0;

        while(true){
            System.out.println("COS2");
            //if(verse==3)break;
            int step = rand.nextInt(8) ;   //liczba 0 odpowiada za lewe gorne pole i rosna zgodnie z kierunkiem wskazowek zegara a w mainie bedzie to zamieniane na ruch
            int [] move = {-1,-1,0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,0};
            lx += move[2*step];
            ly += move[2*step+1];

            try{
                Thread.sleep(00);
            }
            catch (InterruptedException e)
            {

            }
            if(lx <= 28 && ly <= 28 && lx >= 1 && ly >= 1)
            {
                break;//konczy petle jesli nie wychodza poza skale
            }
            lx = a; ly = b; //przywraca lokalizacje do poczatkowej i losuje jeszcze raz

        }
    }
    private int check_bounds(Pool[][] pools, int lx, int ly)
    {
        int verse=0;
        if(!pools[lx-1][ly-1].check()&&!pools[lx-1][ly].check()&&!pools[lx-1][ly+1].check())
        {
            verse++;
        }
        if(!pools[lx][ly-1].check()&&!pools[lx-1][ly+1].check())
        {
            verse++;
        }
        if(!pools[lx+1][ly-1].check()&&!pools[lx+1][ly].check()&&!pools[lx+1][ly+1].check())
        {
            verse++;
        }
        return verse;
    }
}
