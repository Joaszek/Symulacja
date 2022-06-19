import java.util.Scanner;

/*
TODO:
porusznie się ologow 156
 */


/*
flowers finished
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        PARAMETRY NA TERAZ: HP,ATTACK,MAGIC,CRIT,ORKS,OLOGS,FLOWERS,ILOSC ITERACJI

        2. Kiedy program ma się skończyć
         */
        //BARTEK zostaw twój kod z tym args żeby było do badań
        /*double tab[]= new double [8];
        Scanner scanner = new Scanner(System.in);
        Babcia_Sida babcia_sida= new Babcia_Sida();
        System.out.println("Wpisz HP bohatera: ");
        tab[0]=scanner.nextDouble();
        System.out.println("Wpisz atak bohatera: ");
        tab[1]=scanner.nextDouble();
        System.out.println("Wpisz magie bohatera: ");
        tab[2]=scanner.nextDouble();
        System.out.println("Wpisz szanse na trafienie krytyczne bohatera: ");
        tab[3]=scanner.nextDouble();

        Bohater PEPE = new Bohater(tab[0], tab[1],tab[2], tab[3]);

        int flowers,orks,ologs;
        System.out.println("Wpisz liczbe orkow(0-300): ");
        orks=scanner.nextInt();
        System.out.println("Wpisz liczbe ologow(0-300): ");
        ologs=scanner.nextInt();
        System.out.println("Wpisz liczbe kwiatow(0-100): ");
        flowers=scanner.nextInt();

        */
        Babcia_Sida babcia_sida= new Babcia_Sida();
        Bohater PEPE = new Bohater(600, 60,50, 50);
        new Map(50,100,100,PEPE,babcia_sida, 200);
        System.out.println("Koniec maina");
    }
}
