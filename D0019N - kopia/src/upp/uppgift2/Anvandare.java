/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;
import java.util.ArrayList;

public class Anvandare {

    private static ArrayList<String> anvandare = new ArrayList<String>();
// Håller reda på och skapar nya användare, samt tillkallar funktionen för pris av medlemsskap
    public static ArrayList<String> getAnvandare() {
        return anvandare;
    }
    public static void addAnvandare(String persID){
        anvandare.add(persID);
        Medlemsskapsavgift.pris();
    }

}
