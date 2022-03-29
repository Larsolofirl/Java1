/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;

import java.util.Arrays;

public class Aktivitet {
    //Skapar en array för bokning av platser på aktiviteterna
    String[]platser = {"0","0","0","0","0","0","0","0","0"};
    public String[] getplatser() {
        return platser;
    }
    public void setplatser(String persID, int rad, String plats) {
        int position = 0;
        //Skapar en switch för platsbokningen
        if (0 < rad && rad < 4) {
            switch (plats) {
                case "a":
                    position = rad+(2*(rad-1));
                    break;

                case "b":
                    rad--;
                    rad *= 3;
                    rad++;
                    position = rad+1;
                    break;
                case "c":
                    rad--;
                    rad *= 3;
                    rad += 2;
                    position = rad+1;
                    break;


                default:

            }
            //If sats för att bekräfta att du är inloggad och väljer en giltig plats
            if (0 < position && position < 10) {
                if (platser[position - 1].equals("0")) {
                    platser[position - 1] = persID;
                    System.out.println("platsen är nu bokad");
                } else {
                    System.out.println("platsen är uptagen försök igen");
                }
            } else {
                System.out.println("försök igen med en giltig plats");
            }
        } else {
            System.out.println("försök igen med en giltig plats");
        }
    }
}