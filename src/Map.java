import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private int size_x;
    private int size_y;
    private int flowers;
    private int orks;
    private int ologs;
    JPanel [][] panels;
    Pool[][] map;
    private Bohater PEPE;
    private Babcia_Sida babcia_sida;
    ArrayList<Ork>Orkowie = new ArrayList<>();
    ArrayList<Olog>Ologi = new ArrayList<>();
    ArrayList<Babcia_MAD>babcie = new ArrayList<>();
    ArrayList<Flower>kwiatki = new ArrayList<>();

    Map(int x, int y, int flowers, int ologs, int orks, Bohater PEPE, Babcia_Sida babcia_sida)
    {
        this.size_x=x;
        this.size_y=y;
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
        int rand_1 = random.nextInt(30);
        int rand_2 = random.nextInt(30);
        //add bohater
        if(map[rand_1][rand_2].is_empty)
        {
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
        for(int i = 0; i<orks; i++){
            int k = 0;
            while(k==0) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
                if(map[rand_1][rand_2].is_empty){
                    Orkowie.add(new Ork());
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id = 4;
                    k=1;    //zamyka
                }
            }
        }

        //add ologs
        for(int i = 0; i<ologs; i++){
            int k = 0;
            while(k==0) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
                if(map[rand_1][rand_2].is_empty){
                    Ologi.add(new Olog());
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=5;
                    k=1;    //zamyka
                }
            }
        }
        //add babcia MAD
        for(int i = 0; i<10; i++){
            int k = 0;
            while(k==0) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
                if(map[rand_1][rand_2].is_empty){
                    babcie.add(new Babcia_MAD());
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id = 3;
                    k=1;    //zamyka
                }
            }
        }

        //add flowers
        for(int i = 0; i<flowers; i++){
            int k = 0;
            while(k==0) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
                if(map[rand_1][rand_2].is_empty){
                    kwiatki.add(new Flower());
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=6;
                    k=1;    //zamyka
                }
            }
        }
        //add pierscien

        if(map[rand_1][rand_2].is_empty){
            new Pierscien();
            map[rand_1][rand_2].id = 8;
        }
        //add item

       /* for(int i = 0; i<item; i++){      //to do itema potem
            int k = 0;
            while(k==0) {   //po to jezeli sie nie wylosuje puste pole to losowalo jeszcze raz bez psucia fora
                rand_1 = random.nextInt(30);
                rand_2 = random.nextInt(30);
                if(map[rand_1][rand_2].is_empty){
                    kwiatki.add(new Flower());
                    map[rand_1][rand_2].is_empty = false;
                    map[rand_1][rand_2].id=6;
                    k=1;    //zamyka
                }
            }
        }*/



        new Frame(map);
    }
    public void set_Panels()
    {
        panels = new JPanel[size_x][size_y];
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
