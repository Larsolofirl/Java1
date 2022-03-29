/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift2;
import java.util.Arrays;
import java.util.Scanner;

public class WakeUp {
    public static void main(String[] args) {
        //Skapar scanner
        Scanner input = new Scanner(System.in);
            Aktivitet spinning = new Aktivitet();
            Aktivitet yoga = new Aktivitet();
            Aktivitet aerobics = new Aktivitet();
            boolean on = true;

            //Skapar en loopad meny
            while(on) {
                System.out.println("Välkommen till Gym WakeUp!");
                System.out.println("1: Bli medlem");
                System.out.println("2: Logga In");
                System.out.println("3: Boka plats på aktivitet");
                System.out.println("4: Avsluta");
                int menyval = input.nextInt();
                //Skapar switchsats för menyval
                switch (menyval) {
                    //Skapa medlem med personnummer samt medlemsavgift
                    case 1:
                        System.out.println("Ange ett 10-siffrigt giltigt personnummer (YYMMDD-XXXX)");
                        String persID = input.nextLine();
                        persID = input.nextLine();
                        if (Validering.validering(persID)) {
                            System.out.println("Hur länge vill du vara medlem?");
                            Anvandare.addAnvandare(persID);
                        } else {
                            System.out.println("Fel");
                        }
                        break;
                    //Tar emot ett registrerat personnummer från arrayen för att logga in användaren
                    case 2:
                        System.out.println("Logga in med ditt personnummer (YYMMDD-XXXX)");
                        String persID2 = input.nextLine();
                        persID2 = input.nextLine();
                        if (Anvandare.getAnvandare().contains(persID2)) {
                            Inloggning.setInloggad(persID2);
                            System.out.println("Du är nu inloggad");
                        } else {
                            System.out.println("Inloggning misslyckades, du är inte medlem");
                        }
                        break;
                    //Kombination av if sats och switch case för att visa lediga bokade platser samt bokning av aktivitet
                    case 3:
                        if (Inloggning.getInloggad()!= null) {

                            System.out.println("Välj en aktivitet");
                            System.out.println("1: Spinning");
                            System.out.println("2: Aerobics");
                            System.out.println("3: Yoga");
                            menyval = input.nextInt();
                            String menyval2;

                            switch (menyval) {
                                case 1:
                                    System.out.print("  a b c");

                                    for (int i=0; i<spinning.getplatser().length; i++){
                                        if (i%3==0){
                                            System.out.print("\n"+(i/3+1));
                                        }
                                        if (spinning.getplatser()[i]=="0"){
                                            System.out.print(" 0");
                                        } else {
                                            System.out.print(" x");
                                        }
                                    }
                                    System.out.println("\nVälj rad 1-3");
                                    menyval = input.nextInt();

                                    System.out.println("välj plats a-c");
                                    menyval2 = input.next();
                                    spinning.setplatser(Inloggning.getInloggad(), menyval, menyval2);

                                    break;

                                case 2:
                                    System.out.print("  a b c");

                                    for (int i=0; i<aerobics.getplatser().length; i++){
                                        if (i%3==0){
                                            System.out.print("\n"+(i/3+1));
                                        }
                                        if (aerobics.getplatser()[i]=="0"){
                                            System.out.print(" 0");
                                        } else {
                                            System.out.print(" x");
                                        }
                                    }
                                    System.out.println("\nVälj rad 1-3");
                                    menyval = input.nextInt();

                                    System.out.println("välj plats a-c");
                                    menyval2 = input.next();
                                    aerobics.setplatser(Inloggning.getInloggad(), menyval, menyval2);

                                    break;

                                case 3:
                                    System.out.print("  a b c");

                                    for (int i=0; i<yoga.getplatser().length; i++){
                                        if (i%3==0){
                                            System.out.print("\n"+(i/3+1));
                                        }
                                        if (yoga.getplatser()[i]=="0"){
                                            System.out.print(" 0");
                                        } else {
                                            System.out.print(" x");
                                        }
                                    }
                                    System.out.println("\nVälj rad 1-3");
                                    menyval = input.nextInt();

                                    System.out.println("välj plats a-c");
                                    menyval2 = input.next();
                                    yoga.setplatser(Inloggning.getInloggad(), menyval, menyval2);

                                    break;
                                default:
                                    // Meddelanden för ogiltiga val av platser
                                    System.out.println("Ogiltigt val, välj ett giltigt alternativ");
                                    break;
                            }
                        } else {
                            System.out.println("Du måste logga in för att boka plats");

                        }
                        break;
                    case 4:
                        System.out.println("Tack för att du besöker Gym WakeUp!");
                        on = false;
                        break;
                    default:
                        System.out.println("Ogiltigt val, välj ett giltigt alternativ");
                        break;

                }

            }
        // Stänger scanner
        input.close();
        }

    }
