/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;

public class Inloggning {
    private static String inloggad;
// Tar emot ett giltigt registrerat personnumer för att logga in användare
    public static String getInloggad(){
        return inloggad;
    }
    public static void setInloggad(String persID){
        inloggad = persID;
    }
}
