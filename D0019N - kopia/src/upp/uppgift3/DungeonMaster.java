/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;
//
public class DungeonMaster {
    //skapar objektet dungeon av klassen dungeon samt anropar metoder i dungeon
    public static void startgame(){
        Dungeon dungeon = new Dungeon();
        dungeon.createRooms();
        dungeon.setup();
        dungeon.playGame();

    }
    public static void endgame(){
      System.exit(0);
    }

    public static void main(String[] args) {
        startgame();
        endgame();
    }
}
