import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    Random rand = new Random();
    private final int sizeX;
    private final int sizeY;
    private int flowers;
    private int orks;
    private int ologs;
    private int rand_1, rand_2;
    private static int cflowers;          //ile zjadl kwiatkow
    private static int cologs;
    private static int corks;
    JPanel [][] panels;
    Pool[][] map;
    private final Bohater PEPE;
    private final Babcia_Sida babcia_sida;
    private static ArrayList<Ring> rings = new ArrayList<>();
    private  ArrayList<Ork> orcs = new ArrayList<>();
    private ArrayList<Olog> ologi = new ArrayList<>();
    private ArrayList<Babcia_MAD> babcie = new ArrayList<>();
    private ArrayList<Flower> kwiatki = new ArrayList<>();
    private Item[] itemy = new Item[30];
    Frame myframe;
    Map(Babcia_Sida babcia_sida, Bohater PEPE, int iterations)
    {
        this.sizeX = 30;
        this.sizeY = 30;
        this.PEPE = PEPE;
        this.babcia_sida = babcia_sida;
        for(int i=0; i<iterations;i++){
        new Research();
        this.flowers = Research.getParameters()[0];
        this.ologs = Research.getParameters()[1];
        this.orks = Research.getParameters()[2];
        PEPE.set_hp(Research.getParameters()[4]);
        PEPE.set_attack(Research.getParameters()[5]);

        set_Map();

    }
    }
    public void set_Map()
    {
        //setting pools
        setMap();
        random();       //losowanie
        //add bohater
        if(map[rand_1][rand_2].is_empty)
        {
            PEPE.lx=rand_1;
            PEPE.ly=rand_2;
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 1;
        }
        //add babcia sida
        random();
        if(map[rand_1][rand_2].is_empty)
        {
            babcia_sida.SetX(rand_1);
            babcia_sida.SetY(rand_2);
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 2;
        }
        //add orks
        for(int i = 0; i<orks; i++) {
            while (!map[rand_1][rand_2].is_empty) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                random();;
            }
            Ork temp_ork = new Ork(rand_1,rand_2);
            orcs.add(temp_ork);
            map[rand_1][rand_2].orks.add(temp_ork);
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 4;
        }

        //add ologs
        for(int i = 0; i<ologs; i++){
            while(!map[rand_1][rand_2].is_empty)
            {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                random();
            }
            Olog temp_olog = new Olog(rand_1,rand_2);
            ologi.add(temp_olog);
            map[rand_1][rand_2].ologs.add(temp_olog);
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=5;
        }
        //add babcia MAD
        for(int i = 0; i<10; i++){
            while(!map[rand_1][rand_2].is_empty)
            {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                random();
            }
            Babcia_MAD temp_babcia_m= new Babcia_MAD();
            babcie.add(temp_babcia_m);
            map[rand_1][rand_2].setBabcia_mad(temp_babcia_m);
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 3;
        }

        //add flowers
        for(int i = 0; i<flowers; i++){
            while(!map[rand_1][rand_2].is_empty)    //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
            {
                random();
            }
            map[rand_1][rand_2].flowers=new Flower();
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=6;

        }
        //add pierscien
            setRing(11);
            setRing(0.121);
        //add item
       for(int i = 0; i<Research.getParameters()[3]; i++){      //to do itema potem
            while(!map[rand_1][rand_2].is_empty) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                random();
            }
                if(map[rand_1][rand_2].is_empty){
                    itemy[i]=new Item();
                    map[rand_1][rand_2].item=itemy[i];
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=7;
                }
        }

       myframe = new Frame(map);
       SecondFrame second_frame=new SecondFrame(PEPE,myframe);
        while(!ologi.isEmpty() || !orcs.isEmpty())                //chodzenie etc
        {
            for(Olog olog:ologi)
            {
                int stay=can_go(map,olog.getLx(),olog.getLy());
                if(stay!=1)
                {
                    olog.walk(map,olog);
                }
            }
            for(Ork ork: orcs)
            {
                int stay=can_go(map,ork.getLx(),ork.getLy());
                if(stay!=1)
                {
                    ork.walk(map,ork);
                }
            }
            //poruszanie się bohatera
            PEPE.walk(map, PEPE);
            //flowers
            if(map[PEPE.getLx()][PEPE.getLy()].id==6)
            {
                //ustawianie kwiatkow
                PEPE.hp+=map[PEPE.getLx()][PEPE.getLy()].flowers.heal_me();
                cflowers++;
            }
            //fight
            //przepisać do metody fight
            else if(map[PEPE.getLx()][PEPE.getLy()].id==5)
            {
                //ologs
                while(PEPE.get_hp()>0&&map[PEPE.getLx()][PEPE.getLy()].ologs.get(0).get_hp()>0)
                {
                    PEPE.change_hp(-3*map[PEPE.getLx()][PEPE.getLy()].ologs.get(0).get_attack());
                    map[PEPE.getLx()][PEPE.getLy()].ologs.get(0).change_hp(-10*PEPE.get_attack());
                }
                if(PEPE.get_hp()<=0)
                {
                    babcia_sida.wyczysc_kanwe(ologi, orcs,map);
                    break;
                }
                map[PEPE.getLx()][PEPE.getLy()].id=0;
                map[PEPE.getLx()][PEPE.getLy()].ologs.clear();
                PEPE.addKill();
                cologs++;
            }
            else if(map[PEPE.getLx()][PEPE.getLy()].id==4)
            {
                //orks
                while(PEPE.get_hp()>0&&map[PEPE.getLx()][PEPE.getLy()].orks.get(0).get_hp()>0)
                {
                    PEPE.change_hp(-3*map[PEPE.getLx()][PEPE.getLy()].orks.get(0).get_attack());
                    map[PEPE.getLx()][PEPE.getLy()].orks.get(0).change_hp(-10*PEPE.get_attack());
                }
                if(PEPE.get_hp()<=0)
                {
                    babcia_sida.wyczysc_kanwe(ologi, orcs,map);
                    break;
                }
                map[PEPE.getLx()][PEPE.getLy()].id=0;
                map[PEPE.getLx()][PEPE.getLy()].orks.clear();
                PEPE.addKill();
                corks++;
                //potem do wyjebania jak sie fight() ogarnie XD
            }
            //itemy
            else if (map[PEPE.getLx()][PEPE.getLy()].id==7)
            {
                Item tempItem=map[PEPE.getLx()][PEPE.getLy()].getItem();
                PEPE.attack+=tempItem.getItemDamage();
                PEPE.armor+=tempItem.getArmor();
            }
            else if(map[PEPE.getLx()][PEPE.getLy()].id==2){//babcia saida
                //System.out.println("atak bez bonusu to: " + PEPE.get_attack());
                PEPE.set_bonus_attack(babcia_sida.bonus_ad());
                map[PEPE.getLx()][PEPE.getLy()].id=0;
                second_frame.changeSetBabcia();
                //zrobic wyczysc kanwe
            }
            else if(map[PEPE.getLx()][PEPE.getLy()].id==8 && PEPE.isHas_ring() == false){
                map[PEPE.getLx()][PEPE.getLy()].rings.get(0).Power(PEPE);
                PEPE.setHas_ring();
            }
            //tu będzie ustawianie kolorów
            map[PEPE.getLx()][PEPE.getLy()].id=1;
            set_Colors();
            second_frame.change_data();
        }
        for(Ork orc: orcs){
            System.out.println(orc.get_hp());
        }
       /* System.out.println("Kills: "+PEPE.getKills());
        System.out.println("MR: "+PEPE.magic_resist);
        System.out.println("Armor"+PEPE.armor);
        System.out.println("Attack"+PEPE.get_attack());
        System.out.println("Flowers eaten: "+cflowers);
        System.out.println("Koniec");*/
        Research.saveTxt(PEPE);
    }
    private void setMap()
    {
        map = new Pool[30][30];
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                map[i][j]=new Pool();
            }
        }
    }
    private void set_Colors()
    {
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                if(i==0||j==0||i==29||j==29)
                {
                    myframe.panels[i][j].setBackground(Color.GRAY);
                    myframe.panels[i][j].setForeground(Color.GRAY);
                }
                else if(map[i][j].id==1)
                {
                    //bohater
                    myframe.panels[i][j].setForeground(Color.BLACK);
                    myframe.panels[i][j].setBackground(Color.BLACK);
                }
                else if(map[i][j].id==2)
                {
                    //babcia Sida
                    myframe.panels[i][j].setForeground(Color.BLUE);
                    myframe.panels[i][j].setBackground(Color.BLUE);
                }
                else if(map[i][j].id==3)
                {
                    //babcia Mad
                    myframe.panels[i][j].setForeground(Color.PINK);
                    myframe.panels[i][j].setBackground(Color.PINK);
                }
                else if(map[i][j].id==4)
                {
                    //ork
                    myframe.panels[i][j].setForeground(Color.RED);
                    myframe.panels[i][j].setBackground(Color.RED);
                }
                else if(map[i][j].id==5)
                {
                    //ologs
                    myframe.panels[i][j].setForeground(Color.MAGENTA);
                    myframe.panels[i][j].setBackground(Color.MAGENTA);
                }
                else if(map[i][j].id==6)
                {
                    //flower
                    myframe.panels[i][j].setForeground(Color.GREEN);
                    myframe.panels[i][j].setBackground(Color.GREEN);
                }
                else if(map[i][j].id==7)
                {
                    //item
                    myframe.panels[i][j].setForeground(new Color(160,82,40));
                    myframe.panels[i][j].setBackground(new Color(109, 52, 9));
                }
                else if(map[i][j].id==8)
                {
                    //rings
                    myframe.panels[i][j].setForeground(Color.YELLOW);
                    myframe.panels[i][j].setBackground(Color.YELLOW);
                }
                else if(map[i][j].id==0)
                {
                    myframe.panels[i][j].setForeground(Color.WHITE);
                    myframe.panels[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    private int can_go(Pool[][] map, int x, int y)
    {
        if(map[x-1][y-1].id!=0&&map[x][y-1].id!=0&&map[x+1][y-1].id!=0&&map[x-1][y].id!=0&&map[x+1][y].id!=0&&map[x-1][y+1].id!=0&&map[x][y+1].id!=0&&map[x+1][y+1].id!=0)
        {
            return 1;
        }
        return 0;
    }

    private void random(){
        rand_1 = rand.nextInt(28)+1;
        rand_2 = rand.nextInt(28)+1;
    }

    private void setRing(double power){
        while(!map[rand_1][rand_2].is_empty)    //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
        {
            random();
        }
        map[rand_1][rand_2].is_empty = false;
        map[rand_1][rand_2].id=8;
        map[rand_1][rand_2].rings.add(new Ring(power));
    }
    public static String getflowers(){
        return String.valueOf(cflowers);
    }
    public static String getologs() {
        return String.valueOf(cologs);
    }
    public static String getorks(){
        return String.valueOf(corks);
    }




}