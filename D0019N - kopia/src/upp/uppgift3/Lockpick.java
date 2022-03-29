/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;

//samma som key/nyckel
//lockpick klass som ärver från Item
public class Lockpick extends Item {

    public Lockpick(String itemName, String itemType, String itemEffect) {
        super(itemName, itemType, itemEffect);
    }

    public static Item createLockpick(){
        return new Lockpick("Lockpick","Lockpick","Lockpick");
    }
}