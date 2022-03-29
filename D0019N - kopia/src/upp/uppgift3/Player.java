/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int Hp;
    private int maxHp= 10;
    private int Dmg;
    private List<Item> inventory;

    //
    public Player(String name, int Hp, int Dmg){
        this.name=name;
        this.Hp=Hp;
        this.Dmg=Dmg;
        this.inventory = new ArrayList<>(20); //Skapar en arraylist för spelarens inventory
    }
    public String getName() {
        return name;
    }

    public int getHp() {
                return Hp;
        }
    public int getMaxHp() {
        return maxHp;
        }
    public void setHp(int newHp) {
        this.Hp = newHp;
    }

    public int getDmg() {
            return Dmg;
        }

            public void setDmg(int newDmg) {
                this.Dmg = newDmg;
            }
    public static Player player() {
        return new Player("temp", 10, 1); // Spelarens starting stats, namnet ersätts av första inputen i spelet

    }
    //lägger till item i inventory
    public void addtoinventory(Item item){
        inventory.add(item);

        System.out.println("You picked up a " + item.getItemName());
    }
    //tar bort item som använts
    public void removefrominventory(Item item){
        inventory.remove(item);
        System.out.println("Used " +item.itemName);
    }

    public List<Item> getInventory() {
        return inventory;
    }
    public void setName(String name){
        this.name=name;
    }
}




