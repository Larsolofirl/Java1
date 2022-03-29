/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;
import java.util.Scanner;


public class Medlemsskapsavgift {
    public static void pris() {

        Scanner input = new Scanner(System.in);

        // Ser till att grundavgiften för medlemsskap alltid räknas in

        int totalKostnad = 0;
        int månadsKostnad=0;
        // Printar ut information om priser för registrering
        System.out.println("Medlemsavgift 100kr");
        System.out.println("1-2 månader 400kr/månad, 3-6 månader 350kr/månad, 7-12 månader 300kr/månad, mer än 12 månader 250kr/månad");
        System.out.println("Svara i antal månader med siffror");
        int antalmånader = input.nextInt();
        // Beräknar rabatten beroende på medlemsskapets längd
        if (antalmånader >= 1 && antalmånader <= 2) {
            månadsKostnad = 400;
        } else if (antalmånader >= 3 && antalmånader <= 6) {
            månadsKostnad = 350;
        } else if (antalmånader >= 7 && antalmånader <= 12) {
            månadsKostnad = 300;
        } else if (antalmånader > 12) {
            månadsKostnad = 250;
        }
        // Skriver ut det slutgiltiga priset
        totalKostnad = antalmånader * månadsKostnad + 100;
        System.out.println("Totala kostnaden " + totalKostnad + " kr");
        System.out.println("Medlem skapades!");

    }

}