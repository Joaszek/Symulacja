import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private final int sizeX;
    private final int sizeY;
    private final int flowers;
    private final int orks;
    private final int ologs;
    JPanel [][] panels;
    Pool[][] map;
    private final Bohater PEPE;
    private final Babcia_Sida babcia_sida;
    private ArrayList<Ork> orkowie = new ArrayList<>();
    private ArrayList<Olog> ologi = new ArrayList<>();
    private ArrayList<Babcia_MAD> babcie = new ArrayList<>();
    private ArrayList<Flower> kwiatki = new ArrayList<>();
    private Item[] itemy = new Item[30];
    Frame myframe;
    Map(int flowers, int ologs, int orks, Bohater PEPE, Babcia_Sida babcia_sida, int ilosc_iteracji)
    {
        this.sizeX = 30;
        this.sizeY = 30;
        this.flowers=flowers;
        this.ologs=ologs;
        this.orks=orks;
        this.PEPE=PEPE;
        this.babcia_sida=babcia_sida;


        set_Map();

    }
    public void set_Map()
    {
        //setting pools
        setMap();
        Random random = new Random();
        int rand_1 = random.nextInt(28)+1;
        int rand_2 = random.nextInt(28)+1;
        //add bohater
        if(map[rand_1][rand_2].is_empty)
        {
            //bohater works
            PEPE.lx=rand_1;
            PEPE.ly=rand_2;
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 1;

        }
        //add babcia sida
        rand_1 = random.nextInt(28)+1;
        rand_2 = random.nextInt(28)+1;
        if(map[rand_1][rand_2].is_empty)
        {
            babcia_sida.x=rand_1;
            babcia_sida.y=rand_2;
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 2;
        }
        //add orks
        for(int i = 0; i<orks; i++) {
            while (!map[rand_1][rand_2].is_empty) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(28)+1;
                rand_2 = random.nextInt(28)+1;
            }
            orkowie.add(new Ork(rand_1,rand_2));
            //zrob imie
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 4;
        }

        //add ologs
        for(int i = 0; i<ologs; i++){
            while(!map[rand_1][rand_2].is_empty)
            {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(28)+1;
                rand_2 = random.nextInt(28)+1;
            }
            ologi.add(new Olog(rand_1,rand_2));
            //zrob imie
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=5;
        }
        //add babcia MAD
        for(int i = 0; i<10; i++){
            while(!map[rand_1][rand_2].is_empty)
            {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(28)+1;
                rand_2 = random.nextInt(28)+1;
            }
            babcie.add(new Babcia_MAD());
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 3;
        }

        //add flowers
        for(int i = 0; i<flowers; i++){
            while(!map[rand_1][rand_2].is_empty)    //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
            {
                rand_1 = random.nextInt(28)+1;
                rand_2 = random.nextInt(28)+1;
            }
            //kwiatki.add(new Flower());
            map[rand_1][rand_2].flowers=new Flower();
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=6;

        }
        //add pierscien
        rand_1 = random.nextInt(28)+1;
        rand_2 = random.nextInt(28)+1;
        if(map[rand_1][rand_2].is_empty){
            //dodac szczegoly pierscienia
            new Pierscien("cos1");
            map[rand_1][rand_2].id = 8;
        }
        rand_1 = random.nextInt(28)+1;
        rand_2 = random.nextInt(28)+1;
        if(map[rand_1][rand_2].is_empty)
        {
            new Pierscien("Cos2");
            map[rand_1][rand_2].id=8;
        }
        //add item

       for(int i = 0; i<30; i++){      //to do itema potem

            while(!map[rand_1][rand_2].is_empty) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(28)+1;
                rand_2 = random.nextInt(28)+1;
            }
                if(map[rand_1][rand_2].is_empty){
                    itemy[i]=new Item();
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=7;
                }

        }

       myframe = new Frame(map);
       SecondFrame second_frame=new SecondFrame(PEPE,myframe);

        while(PEPE.hp>0)
        {
            for(Olog olog:ologi)
            {
                map[olog.getLx()][olog.getLx()].Ologs.remove(olog);
                map[olog.getLx()][olog.getLy()].id=0;
                //olog.walk(map,map[olog.getLx()][olog.getLy()]);
                map[olog.getLx()][olog.getLy()].Ologs.add(olog);
                map[olog.getLx()][olog.getLy()].id=5;
            }
            for(Ork ork:orkowie)
            {
                map[ork.getLx()][ork.getLx()].Orks.remove(ork);
                map[ork.getLx()][ork.getLx()].id=0;
                //ork.walk(map,map[ork.getLx()][ork.getLy()]);
                map[ork.getLx()][ork.getLy()].Orks.add(ork);
                map[ork.getLx()][ork.getLx()].id=4;
            }
            map[PEPE.getLx()][PEPE.getLy()].bohater.clear();
            map[PEPE.getLx()][PEPE.getLy()].id=0;
            PEPE.walk(map,map[PEPE.getLx()][PEPE.getLy()]);
            map[PEPE.getLx()][PEPE.getLy()].bohater.add(PEPE);

            //flowers
            if(map[PEPE.getLx()][PEPE.getLy()].id==6)
            {
                PEPE.hp+=map[PEPE.getLx()][PEPE.getLy()].flowers.heal_me();
            }
            //fight
            //przepisać do metody fight
            else if(map[PEPE.getLx()][PEPE.getLy()].id==5)
            {
                //ologs
                System.out.println("HP:"+map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_hp());
                System.out.println("Damage"+-10*map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_attack());
                System.out.println("PEPE HP"+PEPE.get_hp());
                while(PEPE.get_hp()>0&&map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_hp()>0)
                {
                    PEPE.set_hp(-10*map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_attack());
                    map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).set_hp(-10*PEPE.get_attack());
                    System.out.println("HP:"+map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_hp());
                    System.out.println("Damage"+-10*map[PEPE.getLx()][PEPE.getLy()].Ologs.get(0).get_attack());
                    System.out.println("PEPE HP"+PEPE.get_hp());
                }
                if(PEPE.get_hp()<=0)
                {
                    break;
                }
                map[PEPE.getLx()][PEPE.getLy()].id=0;
                //map[PEPE.getLx()][PEPE.getLy()].Ologs.clear();
            }
            else if(map[PEPE.getLx()][PEPE.getLy()].id==4)
            {
                //orks
               // while(PEPE.get_hp()>0&&map[PEPE.getLx()][PEPE.getLy()].Orks.get(0).get_hp()>0)
                {
                    //PEPE.set_hp(-10*map[PEPE.getLx()][PEPE.getLy()].Orks.get(0).get_attack());
                    //map[PEPE.getLx()][PEPE.getLy()].Orks.get(0).set_hp(-10*PEPE.get_attack());
                }
                //map[PEPE.getLx()][PEPE.getLy()].id=0;
                //map[PEPE.getLx()][PEPE.getLy()].Orks.clear();
                if(PEPE.get_hp()<=0)
                {
                    break;
                }

            }

            //tu będzie ustawianie kolorów
            map[PEPE.getLx()][PEPE.getLy()].id=1;
            set_Colors();
            second_frame.change_data();
            System.out.println("PEPE HP @:"+PEPE.get_hp());
        }
        System.out.println("PEPE HP @:"+PEPE.get_hp());
        System.out.println("Koniec");
    }
    public void   set_Panels()
    {
        panels = new JPanel[sizeX][sizeY];
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
}