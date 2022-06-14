import javax.swing.*;
import java.awt.*;

//nie zrobiony
public class SecondFrame extends JFrame {
    JLabel kills;
    JLabel hp;
    boolean has_babcia;
    Bohater PEPE;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    double number_of_hp=0;
    SecondFrame(Bohater PEPE, Frame myFrame)
    {
        this.PEPE=PEPE;
        kills=new JLabel();
        hp=new JLabel();
        has_babcia=false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(new GridLayout(3,1));
        this.setLocation(myFrame.getX()+myFrame.getWidth(),myFrame.getY());
        set_graphics();
    }
    private void setKills()
    {
        kills = new JLabel();
        kills.setText(String.valueOf(PEPE.getKills()));
        kills.setFont(new Font("Comic Sans",Font.CENTER_BASELINE,25));

    }
    private void setHp()
    {
        hp = new JLabel();
        hp.setText(String.valueOf(PEPE.hp));
        hp.setFont(new Font("Comic Sans",Font.CENTER_BASELINE,25));
    }
    private void setHas_babcia()
    {
        if(has_babcia)
        {
            panel3.setBackground(Color.GREEN);
        }
        else
        {
            panel3.setBackground(Color.RED);
        }
    }
    private void set_panels()
    {
        setHp();
        setKills();
        //panel1
        panel1= new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.add(kills);
        //panel2
        panel2= new JPanel();
        panel2.setLayout(new GridBagLayout());
        //panel3
        panel3 = new JPanel();
        panel2.add(hp);
        setHas_babcia();
    }

    private void set_graphics()
    {
        set_panels();
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
    }
    public void change_data()
    {
        kills.setText(String.valueOf(PEPE.getKills()));
        hp.setText(String.valueOf((int)PEPE.hp));
    }
    public void changeSetBabcia()
    {
        panel3.setBackground(Color.GREEN);
    }
}
