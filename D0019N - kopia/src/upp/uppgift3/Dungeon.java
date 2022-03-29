/**
 * @author  Gustav Segerlind Olof Röjvall David Hägg
 */
package upp.uppgift3;

import java.util.Scanner;

public class Dungeon {
    private Room[][] rooms;
    private Room currentRoom;
    private int currX;
    private int currY;
    private Player player =Player.player();
    private String desc;

// Introt till spelet där spelaren för mata in sitt namn
    public void setup(){
        System.out.println("You come across the hidden entrance of what appears to be a small dungeon.\n" +
                "You can see a dark room inside.\n" +
                "Filled with greed and excitement you carelessly venture into the dungeon with your trusty sword in hand.\n" +
                "What is your name adventurer?");
        Scanner input = new Scanner(System.in);
        this.player.setName(input.nextLine());
        System.out.println("Greetings "+player.getName());

    }
// Startar spelet
    public void playGame() {
        currentRoom.doNarrative();
        boolean running = true;


        Scanner input = null;
        while (running) {
            input = new Scanner(System.in);

            // Berättar för spelaren vart dom kan gå, samt om dörrarna låsta eller inte
            System.out.println("Avaliable doors ");
            for (Door doors : currentRoom.getDoors()
            ) {
                System.out.println(doors.getPosition() + " is locked: " + doors.isLocked());

            }
            System.out.println("Avaliable items "); // Berättar för spelaren vilka items dom har och vilken knapp som använder dom
            for (Item items : player.getInventory()
            ) {
                if (items.itemName == "Lockpick") {
                    System.out.println(items.itemName);
                } else if (items.itemName == "Nocco") {
                    System.out.println(items.itemName + " press 1 to use");
                } else if (items.itemName == "Max Health Potion") {
                    System.out.println(items.itemName + " press 2 to use");
                } else if (items.itemName == "dmgPotion") {
                    System.out.println(items.itemName + " press 3 to use");
                } else if (items.itemName == "Double Damage Potion") {
                    System.out.println(items.itemName + " press 4 to use");
                } else if (items.itemName == "RNG Potion") {
                    System.out.println(items.itemName + " press 5 to use");
                }

            }
            //Scannern används
            String dir = input.nextLine();
            switch (dir) {
                case "n":
                    for (Door door : currentRoom.getDoors()) {
                        if (door.getPosition() == 'n') {
                            if (!door.isLocked()) {
                                currY--;
                            } else {    // Låser upp dörrar med ett lockpick och tar bort det från inventoryt
                                for (Item items : player.getInventory()) {
                                    if (items.itemName == "Lockpick") {

                                        player.removefrominventory(items);
                                        door.setLocked(false);
                                        currY--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "s":
                    for (Door door : currentRoom.getDoors()) {
                        if (door.getPosition() == 's') {
                            if (!door.isLocked()) {
                                currY++;
                            } else {
                                for (Item items : player.getInventory()) {
                                    if (items.itemName == "Lockpick") {

                                        player.removefrominventory(items);
                                        door.setLocked(false);
                                        currY++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "e":
                    for (Door door : currentRoom.getDoors()) {
                        if (door.getPosition() == 'e') {
                            if (!door.isLocked()) {
                                currX++;
                            } else {
                                for (Item items : player.getInventory()) {
                                    if (items.itemName == "Lockpick") {

                                        player.removefrominventory(items);
                                        door.setLocked(false);
                                        currX++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "w":
                    for (Door door : currentRoom.getDoors()) {
                        if (door.getPosition() == 'w') {
                            if (!door.isLocked()) {
                                currX--;
                            } else {
                                for (Item items : player.getInventory()) {
                                    if (items.itemName == "Lockpick") {
                                        player.removefrominventory(items);
                                        door.setLocked(false);
                                        currX--;

                                    }
                                }
                            }
                        }
                    }
                    break;    // switch för att använda consumables, ger spelaren önskad effekt och tar bort den från spelarens inventory
                case "1":
                    for (Item item :
                            player.getInventory()) {
                        if (item.itemName == "Nocco") {
                            player.setHp(player.getHp() + 3);
                            player.removefrominventory(item);
                            break;
                        }

                    }
                    break;
                case "2":
                    for (Item item :
                            player.getInventory()) {
                        if (item.itemName == "Max Health Potion") {
                            player.setHp(player.getMaxHp());
                            player.removefrominventory(item);
                            break;
                        }

                    }
                    break;
                case "3":
                    for (Item item :
                            player.getInventory()) {
                        if (item.itemName == "dmgPotion") {
                            player.setHp(player.getDmg() + 5);
                            player.removefrominventory(item);
                            break;
                        }

                    }
                    break;
                case "4":
                    for (Item item :
                            player.getInventory()) {
                        if (item.itemName == "Double Damage Potion") {
                            player.setHp(player.getDmg() * 2);
                            player.removefrominventory(item);
                            break;
                        }

                    }
                    break;
                case "5":
                    for (Item item :
                            player.getInventory()) {
                        if (item.itemName == "RNG Potion") {
                            Item.rngPot(player);
                            player.removefrominventory(item);
                            break;
                        }

                    }
                    break;
                case "q":
                    running = false;
                    break;
            }
            currentRoom = this.rooms[currY][currX];
            currentRoom.doNarrative();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentRoom.dobattle(this.player);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (currentRoom.getItem() != null) {
                this.player.addtoinventory(currentRoom.getItem());
                currentRoom.removeItem();
            }
        }
        input.close();//scanner stängs
    }

    public void createRooms(){
        this.rooms = new Room[4][4];
        String descr[][] ={

               // Innehåller alla rumsbeskrivningar i en 2d array

                {"The entrance collapses behind you.\n" +
                        "The room is dark and lit up only by small cracks from the collapsed entrance.\n" +
                        "The walls are covered in moss and you can hear something moving from deeper within the dungeon.",
                        "A dark storage room gets revealed.\n" +
                        "The room has several barrels.\n" +
                        "You loot them for supplies.","It's a big soviet TV studio from the 60s.\n" +
                        "A surreal feeling engulfs your mind.\n" +
                        "Mischievous singing gets closer to you."},
                {"The reek of feces and death attacks your nostrils.\n" +
                        "Dozens of dead rats lay by your feet.","The room has a single chair to the left of the entrance.\n" +
                        "A noose hangs eerily above it.\n" +
                        "You can't help but feel that you are not alone.","The room has a small table with something on it.\n" +
                        "There's a sign above the table that read: \"Obligatory pre-boss item\"\n" +
                        "you scratch your head."},
                {"The room is lit up by two torches on the wall.\n" +
                        "You can see four small jail cells, each one containing a dead prisoner.\n" +
                        "One of them has something in his right hand.","It's completely covered in cobwebs.\n" +
                        "You see a withered corpse in the right corner.","A giant lair is in front of you.\n" +
                        "The torches on the walls light up.\n" +
                        "You were not alone.\n"+
                        "                                                  .~))>>\n"+
                        "                                                 .~)>>\n"+
                        "                                               .~))))>>>\n"+
                        "                                             .~))>>             ___\n"+
                        "                                           .~))>>)))>>      .-~))>>\n"+
                        "                                         .~)))))>>       .-~))>>)>\n"+
                        "                                       .~)))>>))))>>  .-~)>>)>\n"+
                        "                   )                 .~))>>))))>>  .-~)))))>>)>\n"+
                        "                ( )@@*)             //)>))))))  .-~))))>>)>\n"+
                        "              ).@(@@               //))>>))) .-~))>>)))))>>)>\n"+
                        "            (( @.@).              //))))) .-~)>>)))))>>)>\n"+
                        "          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n"+
                        "       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n"+
                        "      )) @@*. )@@ )   (\\_(\\-\\b  |))>)) //)))>>)))))))>>)>\n"+
                        "    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n"+
                        "     )* @@@ )@*     (@)  (@) /\\b|))) //))))))>>))))>>\n"+
                        "   (( @. )@( @ .   _/  /    /  \\b)) //))>>)))))>>>_._\n"+
                        "    )@@ (@@*)@@.  (6///6)- / ^  \\b)//))))))>>)))>>   ~~-.\n"+
                        " ( @jgs@@. @@@.*@_ VvvvvV//  ^  \\b/)>>))))>>      _.     `bb\n"+
                        " ((@@ @@@*.(@@ . - | o |' \\ (  ^   \\b)))>>        .'       b`,\n"+
                        "   ((@@).*@@ )@ )   \\^^^/  ((   ^  ~)_        \\  /           b `,\n"+
                        "     (@@. (@@ ).     `-'   (((   ^    `\\ \\ \\ \\ \\|             b  `.\n"+
                        "       (*.@*              / ((((        \\| | |  \\       .       b `.\n"+
                        "                         / / (((((  \\    \\ /  _.-~\\     Y,      b  ;\n"+
                        "                        / / / (((((( \\    \\.-~   _.`\" _.-~`,    b  ;\n"+
                        "                       /   /   `(((((()    )    (((((~      `,  b  ;\n"+
                        "                     _/  _/      `\"\"\"/   /'                  ; b   ;\n"+
                        "                 _.-~_.-~           /  /'                _.'~bb _.'\n"+
                        "               ((((~~              / /'              _.'~bb.--~\n"+
                        "                                  ((((          __.-~bb.-~\n"+
                        "                                              .'  b .~~\n"+
                        "                                              :bb ,' \n"+
                        "                                              ~~~~\n"}



        };
      // Placerar ut monster i en 2d array
        Monster monster[][] = {
                {null,null,Monster.createMonster("troll")},
                {Monster.createMonster("rat"),Monster.createMonster("ghost"),null},
                {null,Monster.createMonster("spider"),Monster.createMonster("dragon")},


        };    // Placerar ut items i en 2d array
        Item item[][] = {
                {null,Item.newRandomItem(),null},
                {Lockpick.createLockpick(),Lockpick.createLockpick(),Item.newRandomItem()},
                {Item.newRandomItem(),null,null},
        };
            // Placerar ut vart dörrarna i rummen ska finnas.
        Door[] doors[][]={
            {{Door.createDoor('s',false)},{Door.createDoor('s',false),Door.createDoor('e',false)},{Door.createDoor('s',false),Door.createDoor('w',false)}},
            {{Door.createDoor('s',false),Door.createDoor('n',false)},{Door.createDoor('s',false),Door.createDoor('n',false),Door.createDoor('e',true)},{Door.createDoor('s',true),Door.createDoor('n',false),Door.createDoor('w',false)}},
            {{Door.createDoor('n',false),Door.createDoor('e',false)},{Door.createDoor('n',false),Door.createDoor('w',false)},{Door.createDoor('n',false)}},
        };





        for (int x=0;x< rooms.length-1;x++) {
           for (int y = 0; y < rooms.length-1; y++) {

              this.rooms[x][y] = Room.createRoom(descr[x][y], monster[x][y], item[x][y], doors[x][y]);
           }
        }
        this.currentRoom = rooms[0][0];
    }


}
