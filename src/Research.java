import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class Research {
    static File results = new File("C:/Users/Bartek/Downloads/piwo3.txt");

    private String line;
    private String[] split;
    private static int k=1;
    private static final int n = 4;     //to jest liczba parametrow
    private static int [] parameters = new int[n];
    public Research(int ite){
        try{

            Scanner f = new Scanner(new File ("C:/Users/Bartek/Downloads/piwo2.txt"));   //jak chcesz robic u sb to zmien lokalizacje I NIE WRZUCAJ CSV BO SIE WYWALA
            f.useDelimiter("\n");
            for(int c = 0; c<k; c++) this.line = f.nextLine();      //japierdole xdddd wazne ze dziala, skacze do linijki z ktora sa dane do danej iteracji
            this.split = line.split(",");
            for(int i = 0; i<n; i++){
                System.out.println(split[i]);
                parameters[i] = Integer.parseInt(split[i]);      //trim zostawie na razie, idk czy bedzie potrzebny
                //System.out.println(parameters[i]);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("pliku ni ma");
        }
        k++;
    }

    public static void saveTxt(){
        try {
            FileWriter save = new FileWriter(results, true);
            save.append(Map.getflowers() + " ");
            save.append(Map.getologs() + " ");
            save.append(Map.getorks() + "\n");
            save.close();
        }
        catch(IOException h){
            System.out.println("idk man");
            h.printStackTrace();
        }
    }

    public static int[] getParameters(){
        return parameters;
    }
}
