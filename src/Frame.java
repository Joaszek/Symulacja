import javax.swing.*;
import java.awt.*;


//zależnie od tego co w klasie taki kolor będzie mieć
//pink-Babcia Mad
//red - ork
//purple - magenta olog xd?
//blue-babcia sida
//black-bohater
//green - flower
//brown - item
//yellow - pierscien


public class Frame extends JFrame {
    JPanel[][] panels;
    Pool [][]map;
    Frame(Pool[][] map)
    {
        panels= new JPanel[30][30];
        this.map=map;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(30,30));
        setPanels();

        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                this.add(panels[i][j]);
            }
        }
        this.setSize(900,900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void setPanels()
    {
        for(int i=0;i<30;i++)
        {

            for(int j=0;j<30;j++)
            {
                panels[i][j]=new JPanel();
                if(map[i][j].id==1)
                {
                    //bohater
                    panels[i][j].setForeground(Color.BLACK);
                    panels[i][j].setBackground(Color.BLACK);
                }
                else if(map[i][j].id==2)
                {
                    //babcia Sida
                    panels[i][j].setForeground(Color.BLUE);
                    panels[i][j].setBackground(Color.BLUE);
                }
                else if(map[i][j].id==3)
                {
                    //babcia Mad
                    panels[i][j].setForeground(Color.PINK);
                    panels[i][j].setBackground(Color.PINK);
                }
                else if(map[i][j].id==4)
                {
                    //ork
                    panels[i][j].setForeground(Color.RED);
                    panels[i][j].setBackground(Color.RED);
                }
                else if(map[i][j].id==5)
                {
                    //ologs
                    panels[i][j].setForeground(Color.MAGENTA);
                    panels[i][j].setBackground(Color.MAGENTA);
                }
                else if(map[i][j].id==6)
                {
                    //flower
                    panels[i][j].setForeground(Color.GREEN);
                    panels[i][j].setBackground(Color.GREEN);
                }
                else if(map[i][j].id==7)
                {
                    //item
                    panels[i][j].setForeground(new Color(160,82,40));
                    panels[i][j].setBackground(new Color(109, 52, 9));
                }
                else if(map[i][j].id==8)
                {
                    //rings
                    panels[i][j].setForeground(Color.YELLOW);
                    panels[i][j].setBackground(Color.YELLOW);
                }
            }
        }
    }
    public void check_pool()
    {

    }

}
