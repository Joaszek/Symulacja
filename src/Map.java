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
    static int [][] tab = new int[30][30];     //przechowuje informacje o polozeniu mobków

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
        }
        //add babcia sida
        rand_1 = random.nextInt();
        rand_2 = random.nextInt();

        //add orks

        //add ologs

        //add babcia MAD

        //add flowers

        //add pierscien

        //add item



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
