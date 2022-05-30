import javax.swing.*;
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
        for(int i = 0; i<ilosc_iteracji && PEPE.hp>0; i++){ //tu beda rzeczy sie dzialy, mamy chodzenie ale graficznie tego jeszcze nie ma
            PEPE.walk();
            //System.out.println("kordy bohatera to: " + PEPE.Lx + " " + PEPE.Ly);
            for (Ork ork : orkowie) {
                ork.walk();
            }
            for (Olog olog : ologi) {
                olog.walk();
            }
            //tu bedzie walka
        }
    }
    public void set_Map()
    {
        //setting pools
        setMap();
        Random random = new Random();
        int rand_1 = random.nextInt(30);
        int rand_2 = random.nextInt(30);
        //add bohater
        if(map[rand_1][rand_2].is_empty)
        {
            //bohater works
            PEPE.x=rand_1;
            PEPE.y=rand_2;
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 1;

        }
        //add babcia sida
        rand_1 = random.nextInt(30);
        rand_2 = random.nextInt(30);
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
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
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
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
            }
            ologi.add(new Olog());
            //zrob imie
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=5;
        }
        //add babcia MAD
        for(int i = 0; i<10; i++){
            while(!map[rand_1][rand_2].is_empty)
            {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
            }
            babcie.add(new Babcia_MAD());
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id = 3;
        }

        //add flowers
        for(int i = 0; i<flowers; i++){
            while(!map[rand_1][rand_2].is_empty)    //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
            {
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
            }
            kwiatki.add(new Flower());
            map[rand_1][rand_2].is_empty = false;
            map[rand_1][rand_2].id=6;

        }
        //add pierscien
        rand_1 = random.nextInt(30);
        rand_2 = random.nextInt(30);
        if(map[rand_1][rand_2].is_empty){
            System.out.println("cos");
            //dodac szczegoly pierscienia
            new Pierscien("cos1");
            map[rand_1][rand_2].id = 8;
        }
        rand_1 = random.nextInt(30);
        rand_2 = random.nextInt(30);
        if(map[rand_1][rand_2].is_empty)
        {
            new Pierscien("Cos2");
            map[rand_1][rand_2].id=8;
        }
        //add item

       for(int i = 0; i<30; i++){      //to do itema potem

            while(!map[rand_1][rand_2].is_empty) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
            }
                if(map[rand_1][rand_2].is_empty){
                    itemy[i]=new Item();
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=7;
                }

        }

       Frame myframe = new Frame(map);
       new SecondFrame(PEPE,myframe);

       //tutaj patrz
        while(PEPE.hp>0)
        {
            for(Olog olog:Ologi)
            {
                //olog.mowe();
            }
            for(Ork ork:Orkowie)
            {
                //ork.mowe();
            }
            //tu będzie ustawianie kolorów
            //myframe.panels
        }

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
}
