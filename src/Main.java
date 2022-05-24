import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        PARAMETRY NA TERAZ: HP,ATTACK,MAGIC,CRIT,ORKS,OLOGS,FLOWERS
        1.Zróbmy z 10 miejsce w których jest babcia madagaskar bo 1 na 900 to trochę mało
        2. Kiedy program ma się skończyć
         */


        Babcia_Sida babcia_sida= new Babcia_Sida();
        //Bohater PEPE = new Bohater(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Double.parseDouble(args[4]));
        Bohater PEPE = new Bohater(30,30,30,30);
        int flowers,orks,ologs;
        Scanner scanner = new Scanner(System.in);
        /*
        orks = Integer.parseInt(args[5]);
        ologs = Integer.parseInt(args[6]);
        flowers= Integer.parseInt(args[7]);
        */
        new Map(30,30,30,30,30,PEPE,babcia_sida);
        //mapa
        //bohater
        //rozmieszczenie orkow i ologow

    }
}
