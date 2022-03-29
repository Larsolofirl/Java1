/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;

//monster klass
public class Monster {
    private final String name;
    private int Hp;
    private final int Dmg;
    private final String descr;

    public Monster(String name, int Hp, int Dmg, String descr) {
        this.name = name;
        this.Hp = Hp;
        this.Dmg = Dmg;
        this.descr = descr;
    }
    //get metod som returnerar värden som skada, namn, hp, beskrivning
    public String getName() {
        return name;
    }
    public int getHp() {
        return Hp;
    }
    public void setHp(int newHp) {
            this.Hp=newHp;
    }
    public int getDmg() {
        return Dmg;
    }
    public String getdescr() {
        return descr;
    }

    //skapar switch för monster values samt beskrivning i spelet
    public static Monster createMonster(String type) {
        switch(type)
            {
                case "rat":
                    return new Monster("rat", 2, 1, "A small and feral rat appears, it looks weak.");
                case "spider":
                    return new Monster("spider", 3, 1, "A big spider appears, it looks ready to bite. Gross!");
                case "ghost":
                    return new Monster("ghost", 4, 1, "A ghost appears. It's trapped in this dungeon.");
                case "troll":
                    return new Monster("troll", 5, 1, "A Troll appears. He's a strange, singing, russian man.");
                case "dragon":
                    return new Monster("dragon", 5, 2, "The master of the dungeon," +
                            "a massive dragon appears!");
                default:
                    return null;
    }


    }
}





