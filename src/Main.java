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
        PARAMETRY NA TERAZ: flowers/ologs/orks/number of items/hp/attack/

        2. Kiedy program ma się skończyć
         */
        //BARTEK zostaw twój kod z tym args żeby było do badań
        //double tab[]= new double [8];
        Scanner scanner = new Scanner(System.in);
        /*Babcia_Sida babcia_sida= new Babcia_Sida();
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

        //System.out.println("aby wlaczyc w trybie badan wcisnij 0");
        System.out.println("podaj liczbe iteracji: ");
        int iterations = scanner.nextInt();     //bo mi sie nie chce myslec xd, pamietaj zeby bylo tyle co linijek w txt z parametrami bo jak nie to nie wiem co sie stanie
        Babcia_Sida babcia_sida= new Babcia_Sida();
        Bohater PEPE = new Bohater(1000);
        new Map(babcia_sida, PEPE, iterations);
        System.out.println("Koniec maina");



    }
}
