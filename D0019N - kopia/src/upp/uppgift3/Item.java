/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;
import java.util.Random;

//Super för Lockpick, RNGPotion och Sword

public class Item {

    public String itemName;
    private String itemType;
    private String itemEffect;
    private static Random rand = new Random();

    public Item(String itemName, String itemType, String itemEffect) {

        this.itemName = itemName;
        this.itemType = itemType;
        this.itemEffect = itemEffect;
    }

    //beskriver alla potions i dungeonen, returnar itemName itemType och itemEffect för beskrivning i spelet
    private static Item rngPotion() {
        return new Item("RNG Potion", "Potion", "Gives the player a random effect on use.");
    }

    private static Item dmgPotion() {
        return new Item("Damage Potion", "Potion", "Increases dmg by 5.");

    }

    private static Item doubleDmgPotion() {
        return new Item("Double Damage Potion", "Potion", "Increases dmg by 2x.");

    }

    private static Item hpPotion() {
        return new Item("Nocco", "Potion", "Refills player health.");

    }

    private static Item maxHpPotion() {
        return new Item("Max Health Potion", "Potion", "Increases the player max HP.");
    }

        
        //rand för random item placering
        public static Item newRandomItem() {
            Item randomItem = null;
            int random = rand.nextInt(4) + 1;
        //skapar switch för vilken potion som hamnar vart i dungeonen
        switch (random) {

            case 1:
                randomItem = (hpPotion());
                break;
            case 2:
                randomItem = (maxHpPotion());
                break;
            case 3:
                randomItem = (dmgPotion());
                break;
            case 4:
                randomItem = (doubleDmgPotion());
                break;
            default:
                randomItem = (rngPotion());
                break;
        }
        return randomItem;
    }
    public static void rngPot(Player player){
        int random = rand.nextInt(3) + 1;
        //skapar switch för rng potions outcome av de olika möjliga effekterna
        switch (random) {

            case 1:
                player.setHp(player.getHp()+5);
            case 2:
                player.setHp(player.getMaxHp());
            case 3:
                player.setDmg(player.getDmg()+5);
            case 4:
                player.setDmg(player.getDmg()*2);

        }
    }

    public String getItemName() {
        return itemName;
    }

}
