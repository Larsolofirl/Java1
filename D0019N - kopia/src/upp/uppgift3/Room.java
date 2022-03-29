/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;
// Room klassen, styr rummens layout.
public class Room {
    private Door[] doors; // Bestämmer vart det finns dörrar i rummet
    private Item item; // Bestämmer vilka items som finns i rummet.
    private Monster monster; // Bestämmer om/vilket monster som finns i rummet
    private String descr; // Beskrivningen för rummet

    private Room(String descr, Monster monster, Item item, Door[] doors) {
        this.doors = doors;
        this.item = item;
        this.monster = monster;
        this.descr = descr;
    }

   // Startar en battle om det finns ett levande monster i rummet
    public void dobattle(Player player){
        if(monster != null){
            if(monster.getHp()>0){
                while((player.getHp()>0)&&(monster.getHp()>0)){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monster.setHp(monster.getHp()- player.getDmg()); // Monstret förlorar lika mycket Hp som spelarens Dmg
                    System.out.println("You attack the " + monster.getName() + " and dealt " + player.getDmg()+"Dmg");
                    System.out.println("the "+monster.getName()+" has "+monster.getHp()+"Hp left");

                    if(monster.getHp()>0){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        player.setHp(player.getHp()- monster.getDmg()); // Spelaren förlorar lika mycket Hp som monstrets Dmg
                        System.out.println("The"+monster.getName()+" attack you and dealt " + monster.getDmg() +"Dmg");
                        System.out.println("You have "+player.getHp()+"Hp left");
                    }
                }
                if (player.getHp()<1){ //Om spelaren får slut på Hp avslutas spelet
                    System.out.println("You died");
                    DungeonMaster.endgame();
                }
                System.out.println("You defeated the "+monster.getName()); // Vinstskärm, om draken är död får spelaren en skatt
                if (monster.getName()=="Dragon"){
                    System.out.println(
                                    "                  _.--.\n"+
                                    "              _.-'_:-'||\n"+
                                    "          _.-'_.-::::'||\n"+
                                    "     _.-:'_.-::::::'  ||\n"+
                                    "   .'`-.-:::::::'     ||\n"+
                                    "  /.'`;|:::::::'      ||_\n"+
                                    " ||   ||::::::'      _.;._'-._\n"+
                                    " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
                                    " \'.  ||:::::.-!() oo @!()@.-'_.||\n"+
                                    "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
                                    "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
                                    "      ||-._'-.@.-'_.-' _.-o  |'||\n"+
                                    "      ||=[ '-._.-\\U/.-'    o |'||\n"+
                                    "      || '-.]=|| |'|      o  |'||\n"+
                                    "      ||      || |'|        _| ';\n"+
                                    "      ||      || |'|    _.-'_.-'\n"+
                                    "      |'-._   || |'|_.-'_.-'\n"+
                                    "      '-._'-.|| |' `_.-'\n"+
                                    "           '-.||_/.-'\n");
                    System.out.println("congratulations you beat the dragon");
                    DungeonMaster.endgame();
                }
            }
        }
    }
    public void doNarrative(){ // text som printas när spelaren går in i ett nytt rum.
        System.out.println("You enter the room. \n"
                + descr);
        if (monster !=null){ // Finns det ett monster i rummet introduceras det
            System.out.println(monster.getdescr());
        }
    }
    public static Room createRoom(String descr, Monster monster, Item item , Door[] doors){
        return new Room(descr, monster, item, doors);
    }
    public Door[] getDoors() { // Get sats för att se möjliga vägar att ta i ett rum
        return doors;
    }

    public Item getItem() {
        return item;
    }
    public void removeItem(){ // metod för att ta bort consumables när dom används
        this.item=null;
    }
}

