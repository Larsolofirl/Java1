package upp.uppgift1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Skapar scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Vad är kostnaden?");
        //Scannern används
        int kostnad = input.nextInt();;
        System.out.println("Hur mycket betalar kunden");
        //Scannern används igen
        int cash = input.nextInt();
        int cashBack = cash - kostnad;
        // Skapar en array med de olika valörerna som kunden växlar till
        int[] valorer = {1000,500,200, 100, 50, 20, 2, 1};
        // Skriver ut relevant information
        System.out.println("beloppet är "+kostnad);
        System.out.println("kunden betalar "+cash);
        System.out.println("kunden får tillbaka");
        // Loopar igenom arrayen. Beräknar antalet valörer som ska ges i växel.
        for (int i=0;i<valorer.length;i++){
            if (cashBack/valorer[i]>=1){
                if (valorer[i] < 10){
                    System.out.println(valorer[i]+"kr mynt "+ cashBack/valorer[i] +" st");
                } else {
                    System.out.println(valorer[i] + "kr sedlar " + cashBack / valorer[i] + " st");
                }
            }
            cashBack %= valorer[i];
        }
    }
}