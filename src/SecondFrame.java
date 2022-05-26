import javax.swing.*;

public class SecondFrame extends JFrame {
    JLabel kills;
    JLabel hp;
    boolean has_babcia;
    Bohater PEPE;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    SecondFrame(Bohater PEPE)
    {
        this.PEPE=PEPE;
        kills=new JLabel();
        hp=new JLabel();
        has_babcia=false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(1000,200);
    }
    public static void setKills()
    {

    }
    public static void setHp()
    {

    }
}
