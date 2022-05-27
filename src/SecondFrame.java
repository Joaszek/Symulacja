import javax.swing.*;

//nie zrobiony
public class SecondFrame extends JFrame {
    JLabel kills;
    JLabel hp;
    boolean has_babcia;
    Bohater PEPE;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
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
        this.setLocation(myFrame.getX()+myFrame.getWidth(),myFrame.getY());

    }
    public static void setKills()
    {

    }
    public static void setHp()
    {

    }
}
