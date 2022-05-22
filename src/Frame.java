import javax.swing.*;
import java.awt.*;


//zależnie od tego co w klasie taki kolor będzie mieć
//pink-Babcia Mad
//red - ork
//purple - olog
//blue-babcia sida
//black-bohater
//green - flower
//brown - item
//yellow - pierscien


public class Frame extends JFrame {
    JPanel[][] panels;
    Frame(Pool[][] map)
    {
        panels= new JPanel[30][30];
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(30,30));
        setPanels();
        this.setVisible(true);
        this.setSize(900,900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public void setPanels()
    {
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                panels[i][j]=new JPanel();
            }
        }
    }
    public void check_pool()
    {

    }
}
