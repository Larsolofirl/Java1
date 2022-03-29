package upp.uppgift1;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        //Skapar scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Ange ett tal");
        //Scannern används
        int tal = input.nextInt();
        int fac = 1;
        for (int n = tal; n > 0; n--){
            System.out.println(n);
            fac *= n;
        }
        System.out.println(fac);
    }
}
