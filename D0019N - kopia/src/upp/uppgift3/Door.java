/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;

public class Door {
    private char position;
    private boolean locked;


    private Door(char position, boolean locked){
        this.position=position; //Bestämmer vart i rummet dörren sitter
        this.locked =locked;    // Bestämmer om dörren kräver ett lockpick för att öppnas
    }
    public static Door createDoor(char position, boolean locked) {
        return new Door(position,locked);
    }

    public char getPosition() {
        return position;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
