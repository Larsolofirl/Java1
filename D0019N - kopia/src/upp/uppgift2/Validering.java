/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;
import java.util.Arrays;


public class Validering {
    public static boolean validering(String persID){
        //Definierar persID
        persID = persID.replace("-","");
        persID = persID.replace("+","");
        //Skapar if sats med Luhn-algoritmen för korrekt personnummer vid inloggning
        if ((persID.length()==10)) {
            int summa = 0;
            for (int i = 0; i < persID.length(); i++) {
                int nummer = persID.charAt(i) - '0';
                int prod;
                if (i % 2 != 0) {
                    prod = nummer;
                } else {
                    prod = nummer * 2;
                    if (prod > 9) {
                        prod -= 9;
                    }
                }
                summa += prod;
            }
            System.out.println(persID);
            if (summa % 10 == 0) {
                return true;
            }
        }
        return false;
    }



}
