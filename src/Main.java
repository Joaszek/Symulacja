import java.util.Scanner;

/*
TODO:
orkowie
kolory do poprawy(pojawiają się po śmierci)
babcie do ogarnięcia
itemy
opcjonalnie:
poruszanie się orków i ologów
 */


/*
flowers finished
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        PARAMETRY NA TERAZ: HP,ATTACK,MAGIC,CRIT,ORKS,OLOGS,FLOWERS,ILOSC ITERACJI
        1.Zróbmy z 10 miejsce w których jest babcia madagaskar bo 1 na 900 to trochę mało
        2. Kiedy program ma się skończyć
         */

        Babcia_Sida babcia_sida= new Babcia_Sida(8);
        Bohater PEPE = new Bohater(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Integer.parseInt(args[2]), Double.parseDouble(args[3]));

        int flowers,orks,ologs;

        orks = Integer.parseInt(args[4]);
        ologs = Integer.parseInt(args[5]);
        flowers= Integer.parseInt(args[6]);

        //System.out.println("parametry: " + args[0] + args[1] + args[2] + args[3] + args[4] + args[5] + args[6]);

        new Map(flowers,ologs,orks,PEPE,babcia_sida, Integer.parseInt(args[7]));
    }
}
