import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        1.Zróbmy z 10 miejsce w których jest babcia madagaskar bo 1 na 900 to trochę mało
        2. Kiedy program ma się skończyć
         */
        Babcia_Sida babcia_sida= new Babcia_Sida();
        Bohater PEPE = new Bohater();
        int flowers,orks,ologs;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of orks: ");
        orks = scanner.nextInt();
        System.out.println("Number of ologs: ");
        ologs = scanner.nextInt();
        System.out.println("Number of flowers: ");
        flowers= scanner.nextInt();
        new Map(30,30,flowers,ologs,orks,PEPE,babcia_sida);
        //mapa
        //bohater
        //rozmieszczenie orkow i ologow
    }
}
